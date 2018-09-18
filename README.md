# boot-mybatis-generator
springboot mybatis generator反向生成model、mapper工具
使用方法：
1.在application.properties中配置数据相关参数：
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
spring.datasource.data-username=root
spring.datasource.data-password=111111
spring.datasource.url=jdbc:mysql://127.0.0.1:3306/xxxxxx?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&failOverReadOnly=false&useSSL=false
2.在generatorConfig.xml配置生成文件的路径

  <p>   <!-- Model模型生成器,用来生成含有主键key的类，记录类 以及查询Example类 
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

  <!-- targetPackage：mapper接口dao生成的位置 -->
  <javaClientGenerator type="XMLMAPPER" targetPackage="com.mybatis.generator.mapper" targetProject="./src/main/java">
     <!-- enableSubPackages:是否让schema作为包的后缀 -->
     <property name="enableSubPackages" value="false"/>
  </javaClientGenerator>
  </p>
3.在generatorConfig.xml文件中配置要反向生成model的表和对应的bean对象名称，如：
  <table tableName="ad_product" domainObjectName="AdProduct" enableCountByExample="false"
    enableUpdateByExample="false" enableDeleteByExample="false" enableSelectByExample="false"
    selectByExampleQueryId="false"></table>
 参数具体配置根据实际需求自行配置
4.执行MyBatisGeneratorMain类中的main方法，执行成功后会将.xml、mapper和model对象生成在指定的文件夹下面
