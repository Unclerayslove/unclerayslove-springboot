model层：
    数据访问层
    一张表对应一个实体类
    对应的也可以命名 entity/pojo/domain

    数据对象：xxxDO，xxx 即为数据表名。
    数据传输对象：xxxDTO，xxx 为业务领域相关的名称。
    展示对象：xxxVO，xxx 一般为网页名称。
    POJO 是 DO/DTO/BO/VO 的统称，禁止命名成 xxxPOJO

    【参考】分层领域模型规约：
    • DO（Data Object）：此对象与数据库表结构一一对应，通过 DAO 层向上传输数据源对象。
    • DTO（Data Transfer Object）：数据传输对象，Service 或 Manager 向外传输的对象。
    • BO（Business Object）：业务对象，可以由 Service 层输出的封装业务逻辑的对象。
    • Query：数据查询对象，各层接收上层的查询请求。注意超过 2 个参数的查询封装，禁止使用 Map 类
    来传输。
    • VO（View Object）：显示层对象，通常是 Web 向模板渲染引擎层传输的对象。