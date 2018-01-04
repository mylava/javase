package cn.mylava._300._6_Reflect._210_ORM;

/**
 * comment: 实体类,这里模拟通过实体类创建数据库表的orm操作
 *
 * @author: lipengfei
 * @date: 03/01/2018
 */
@TableName("tb_student")
public class Student {
    @FieldProperties(columnName = "id",type = "int",length = 10)
    private int id;
    @FieldProperties(columnName = "sname",type = "varchar",length = 50)
    private String studentName;
    @FieldProperties(columnName = "age",type = "int",length = 3)
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
