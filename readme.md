组件化
就是在模块化的基础之上进行动态的切换!，其实很简单的
当一个模块切换成app的时候，会涉及到gradle,清单文件，代码的一系列配置

注意事项
需要单独切成moudle的时候  打开config.gradle的文件
然后 修改isMoudle变量，然后同步项目，但是你会发现这时候会报错，因为R文件资源的指向已经发生变化了，
从R.common 变成了 R.moudleb ，这个时候只要删除错误导包，然后快捷键导入r文件就行了.


ARouter原理
我们发现每个模块都有这样的依赖
implementation 'com.alibaba:arouter-api:1.4.1'
annotationProcessor 'com.alibaba:arouter-compiler:1.2.2'

ARouter$$Group$$moudle_b

注解处理器APT
AbstractProcessor
用AutoService来指明该代码在编译时期将会被运行
ARouter$$Group$$moudle_b

TypeElement类型

1 编译时时期扫描注解 AutoService
2 AbstractProcessor 处理注解,然后进行分组,在不同的组里面
3 javapoet 编译时期生成一个java文件，集合里面就塞了这样的数据，路由地址对应这样的对象
route path - 》对应class字节码文件
map映射集合对应一张路由表,然后根据path找寻到地址进行new Intent()进行跳转

//节点自描述 Mirror
        TypeMirror type_Activity = activity.asType();

        TypeElement iService = elementUtils.getTypeElement(Consts.ISERVICE);
        TypeMirror type_IService = iService.asType();


        /**
         * groupMap(组名:路由信息)集合
         */
        //声明 Route 注解的节点 (需要处理的节点 Activity/IService)
        for (Element element : routeElements) {
            //路由信息
            RouteMeta routeMeta;
            // 使用Route注解的类信息
            TypeMirror tm = element.asType();
            log.i("Route Class: " + tm.toString());
            Route route = element.getAnnotation(Route.class);
            //是否是 Activity 使用了Route注解
            if (typeUtils.isSubtype(tm, type_Activity)) {
                routeMeta = new RouteMeta(RouteMeta.Type.ACTIVITY, route, element);
            } else if (typeUtils.isSubtype(tm, type_IService)) {
                routeMeta = new RouteMeta(RouteMeta.Type.ISERVICE, route, element);
            } else {
                throw new RuntimeException("[Just Support Activity/IService Route] :" + element);
            }
            //分组信息记录  groupMap <Group分组,RouteMeta路由信息> 集合
            categories(routeMeta);
        }

// 创建java文件($$Group$$)  组
            String groupClassName = Consts.NAME_OF_GROUP + groupName;
            JavaFile.builder(Consts.PACKAGE_OF_GENERATE_FILE,
                    TypeSpec.classBuilder(groupClassName)
                            .addSuperinterface(ClassName.get(iRouteGroup))
                            .addModifiers(PUBLIC)
                            .addMethod(loadIntoMethodOfGroupBuilder.build())
                            .build()
            ).build().writeTo(filerUtils);


具体跳转的执行逻辑
在ARouter这个类中
 final Context currentContext = null == context ? mContext : context;

        switch (postcard.getType()) {
            case ACTIVITY:
                // Build intent
                final Intent intent = new Intent(currentContext, postcard.getDestination());
                intent.putExtras(postcard.getExtras());

                // Set flags.
                int flags = postcard.getFlags();
                if (-1 != flags) {
                    intent.setFlags(flags);
                } else if (!(currentContext instanceof Activity)) {    // Non activity, need less one flag.
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                }

                // Set Actions
                String action = postcard.getAction();
                if (!TextUtils.isEmpty(action)) {
                    intent.setAction(action);
                }

                // Navigation in main looper.
                runInMainThread(new Runnable() {
                    @Override
                    public void run() {
//look at here                        startActivity(requestCode, currentContext, intent, postcard, callback);
                    }
                });