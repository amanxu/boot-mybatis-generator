# boot-mybatis-generator
springboot mybatis generator反向生成model、mapper工具
使用方法：

1.在application.properties中配置数据相关参数：
<p> spring.datasource.driver-class-name=com.mysql.jdbc.Driver</p>
<p> spring.datasource.data-username=root</p>
<p>spring.datasource.data-password=111111</p>
<p>spring.datasource.url=jdbc:mysql://127.0.0.1:3306/xxxxxx?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&failOverReadOnly=false&useSSL=false</p>
<p>2.在generatorConfig.xml配置生成文件的路径</p>

<p>   <!-- Model模型生成器,用来生成含有主键key的类，记录类 以及查询Example类 
          targetPackage 指定生成的model生成所在的包名,targetProject指定在该项目下所在的路径-->
     <javaModelGenerator targetPackage="com.mybatis.generator.model" targetProject="./src/main/java">
       <property name="enableSubPackages" value="false"/>
       <property name="constructorBased" value="true"/>
       <property name="trimStrings" value="true"/>
       <property name="immutable" value="false"/>
    </javaModelGenerator>   
</p>
<p>   <!--mapper映射文件生成所在的目录 为每一个数据库的表生成对应的SqlMap文件 -->
      <sqlMapGenerator targetPackage="mappers" targetProject="./src/main/resources">
      <property name="enableSubPackages" value="false"/>
   </sqlMapGenerator>
  </p>
<p>   <!-- targetPackage：mapper接口dao生成的位置 -->
  <javaClientGenerator type="XMLMAPPER" targetPackage="com.mybatis.generator.mapper" targetProject="./src/main/java">
     <property name="enableSubPackages" value="false"/>
  </javaClientGenerator>
  </p>
<p> 3.在generatorConfig.xml文件中配置要反向生成model的表和对应的bean对象名称，如：</p>
 <p> <table tableName="ad_product" domainObjectName="AdProduct" enableCountByExample="false"
    enableUpdateByExample="false" enableDeleteByExample="false" enableSelectByExample="false"
    selectByExampleQueryId="false"></table></p>
 <p>  参数具体配置根据实际需求自行配置</p>
 <p> 4.执行MyBatisGeneratorMain类中的main方法，执行成功后会将.xml、mapper和model对象生成在指定的文件夹下面</p>
