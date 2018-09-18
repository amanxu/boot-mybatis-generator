# boot-mybatis-generator
springboot mybatis generator反向生成model、mapper工具
使用方法如下：
1.在application.properties中配置数据相关参数：

  spring.datasource.driver-class-name=com.mysql.jdbc.Driver
  
  spring.datasource.data-username=root
  
  spring.datasource.data-password=111111
  
  spring.datasource.url=jdbc:mysql://127.0.0.1:3306/xxxxxx?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&failOverReadOnly=false&useSSL=false

2.在generatorConfig.xml配置生成文件的路径

<javaModelGenerator targetPackage="com.mybatis.generator.model" targetProject="./src/main/java">
  
  <property name="enableSubPackages" value="false"/>
 
  <property name="constructorBased" value="true"/>
 
  <property name="trimStrings" value="true"/>
 
  <property name="immutable" value="false"/>

</javaModelGenerator>   

<sqlMapGenerator targetPackage="mappers" targetProject="./src/main/resources">
  
  <property name="enableSubPackages" value="false"/>

</sqlMapGenerator>
  
<javaClientGenerator type="XMLMAPPER" targetPackage="com.mybatis.generator.mapper" targetProject="./src/main/java">
  
  <property name="enableSubPackages" value="false"/>

</javaClientGenerator>
  
3.在generatorConfig.xml文件中配置要反向生成model的表和对应的bean对象名称，如：
 
  <table tableName="ad_product" domainObjectName="AdProduct" enableCountByExample="false"
 
    enableUpdateByExample="false" enableDeleteByExample="false" enableSelectByExample="false"
 
    selectByExampleQueryId="false"></table>
 
  参数具体配置根据实际需求自行配置

4.执行MyBatisGeneratorMain类中的main方法，执行成功后会将.xml、mapper和model对象生成在指定的文件夹下面
