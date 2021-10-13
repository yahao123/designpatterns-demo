package com.wyh.designpatternsdemo.combination;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：WangYaHao
 * @date ：Created in 2021/10/12 9:36 上午
 */
public class WithoutCombinationPatternDemo {

    public static void main(String[] args) {
        Department leafDepartment1 = new Department("叶子部门1");

        Department leafDepartment2 = new Department("叶子部门2");

        Department department1 = new Department("子部门");
        department1.getChildrenList().add(leafDepartment1);
        department1.getChildrenList().add(leafDepartment2);

        Department department = new Department("总部门");
        department.getChildrenList().add(department1);

        // 删除部门 以及子部门
        List<Department> childrenList = department.getChildrenList();
        for (Department department2 : childrenList) {
            for (Department department3 : department2.getChildrenList()) {
                department3.remove();
            }
            department2.remove();
        }
        department.remove();
    }



    public static class Department{

        public Department(String name) {
            this.name = name;
        }

        private String name;

        private List<Department> childrenList = new ArrayList<>();

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<Department> getChildrenList() {
            return childrenList;
        }

        public void setChildrenList(List<Department> childrenList) {
            this.childrenList = childrenList;
        }

        public void remove(){
            System.out.println("删除部门:" + name);
        }
    }
}
