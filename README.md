# boot-mybatis-generator
springboot mybatis generator反向生成model、mapper工具
使用方法如下：
1.在application.properties中配置数据相关参数：

  spring.datasource.driver-class-name=com.mysql.jdbc.Driver
  
  spring.datasource.data-username=root
  
  spring.datasource.data-password=111111
  
  spring.datasource.url=jdbc:mysql://127.0.0.1:3306/xxxxxx?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&failOverReadOnly=false&useSSL=false

2.在generatorConfig.xml配置生成文件的路径

```
 <!-- Model模型生成器,用来生成含有主键key的类，记录类 以及查询Example类
           targetPackage 指定生成的model生成所在的包名,targetProject指定在该项目下所在的路径-->
        <javaModelGenerator targetPackage="com.mybatis.generator.model" targetProject="./src/main/java">
            <!-- 是否允许子包，即targetPackage.schemaName.tableName -->
            <property name="enableSubPackages" value="false"/>
            <!-- 是否对model添加 构造函数 -->
            <property name="constructorBased" value="true"/>
            <!-- 是否对类CHAR类型的列的数据进行trim操作 -->
            <property name="trimStrings" value="true"/>
            <!-- 建立的Model对象是否 不可改变  即生成的Model对象不会有 setter方法，只有构造方法 -->
            <property name="immutable" value="false"/>
   </javaModelGenerator>
  
<!--mapper映射文件生成所在的目录 为每一个数据库的表生成对应的SqlMap文件 -->
        <sqlMapGenerator targetPackage="mappers" targetProject="./src/main/resources">
            <property name="enableSubPackages" value="false"/>
        </sqlMapGenerator>
        
```
3.在generatorConfig.xml文件中配置要反向生成model的表和对应的bean对象名称，如：
 ```
  <!-- enableCountByExample:Count语句中加入where条件查询，默认为true开启
        enableUpdateByExample:Update语句中加入where条件查询，默认为true开启
        enableDeleteByExample:Delete语句中加入where条件查询，默认为true开启
        enableSelectByExample:Select多条语句中加入where条件查询，默认为true开启
        selectByExampleQueryId:Select单个对象语句中加入where条件查询，默认为true开启
        schema即为数据库名 tableName为对应的数据库表 domainObjectName是要生成的实体类
        enable*ByExample 是否生成 example类   -->
   <table tableName="ad_material" domainObjectName="AdMaterial" enableCountByExample="false"
     enableUpdateByExample="false" enableDeleteByExample="false" enableSelectByExample="false"
     selectByExampleQueryId="false"></table>
 ```
  参数具体配置根据实际需求自行配置

4.执行MyBatisGeneratorMain类中的main方法，执行成功后会将.xml、mapper和model对象生成在指定的文件夹下面
