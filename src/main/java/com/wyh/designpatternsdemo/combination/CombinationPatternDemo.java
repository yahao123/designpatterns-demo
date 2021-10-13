package com.wyh.designpatternsdemo.combination;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合模式
 *
 * @author ：WangYaHao
 * @date ：Created in 2021/10/12 9:32 上午
 */
public class CombinationPatternDemo {


    public static void main(String[] args) {
        Department leafDepartment1 = new Department("叶子部门1");

        Department leafDepartment2 = new Department("叶子部门2");

        Department department1 = new Department("子部门");
        department1.getChildrenList().add(leafDepartment1);
        department1.getChildrenList().add(leafDepartment2);

        Department department = new Department("总部门");
        department.getChildrenList().add(department1);

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
            if (childrenList != null && childrenList.size() > 0){
                for (Department department : getChildrenList()) {
                    department.remove();
                }
            }
            System.out.println("删除部门:" + name);
        }
    }
}
