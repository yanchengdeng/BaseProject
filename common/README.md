# 基础功能说明
##.网络请求
1.
2.

##工具类（图片加载、）
1.
2.
##常见控件使用方法(广告位、列表、)
1.
2.
##ARouter 路由使用规范
1.
2.
##常量定义（包括路由常量）
1.
2.

思考下如果模块化开发，每个模块单独运行前如果需要登录，则提供登录功能

### 注意事项
1.为了防止资源文件冲突，保证资源文件名称跟上所属的module名称
2. //ARouter 路由 注意！arouter-compiler 这个依赖必须在build.gradle中声明，只在base_module中声明然后引用base_module中引用是无效的！
    '''   kapt  'com.alibaba:arouter-compiler:1.2.2'  '''
3.gradle 中的资源全部放到common中配置，确保版本一直，避免第三方包冲突






