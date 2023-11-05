package com.layout;

import javafx.collections.FXCollections;
import javafx.collections.ObservableFloatArray;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * @author cc
 * @create 2023/10/29
 * @description
 */
public class LayoutfxmldemoController {
//    @FXML
//    Label lu;
//    @FXML
//    Button bu;
//
//    @FXML
//    public void onClick(){
//        lu.setLayoutY(lu.getLayoutY() - 15);
//    }
//
//   public void initialize(){
//        //这里的button事件已经覆盖了onClick方法
//       bu.setOnAction(event -> {
//           System.out.println("initialize 打印机坏了");
//       });
//   }


    @FXML
    private TableColumn<Person, String> name;

    @FXML
    private TableView<Person> tableview;

    @FXML
    private TableColumn<Person, Integer> age;

    public void initialize(){
        //初始化事件，在加载好fxml文件，并且绑定好数据组件以后触发
        ObservableList<Person> cell = FXCollections.observableArrayList();
        name.setCellValueFactory(new PropertyValueFactory<Person,String>("name"));
        age.setCellValueFactory(new PropertyValueFactory<Person,Integer>("age"));

        cell.add(new Person("张三",20));
        cell.add(new Person("李四",30));
        cell.add(new Person("王五",40));
        cell.add(new Person("赵六",50));

        tableview.setItems(cell);
    }
}
