package qianfeng.a7_2recyclerview1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<User> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        initData();

        // 流式布局看起来好像GridView，实际上每个item的大小是可以不同的，而GridView的item大小必须相同。

        MyAdapter adapter = new MyAdapter(this, list);

        // 有三种布局管理器可以设置，分别是线性布局管理器(ListView),网格布局管理器(GridView),流式布局管理器(每个item大小可以不同)

//        recyclerView.setLayoutManager(new LinearLayoutManager(this));// ListView
        // 第二个参数是指定排列的方向，第三个参数是是否反转,false:不反转
//        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));//ListView的水平排列(水平滚动)


//        recyclerView.setLayoutManager(new GridLayoutManager(this,3));// GridView，每列3个item ，第二个参数表示有多少行或者多少列(具体看你指定的方向是水平还是垂直)

//        recyclerView.setLayoutManager(new GridLayoutManager(this,3,GridLayoutManager.HORIZONTAL,false));// 表示每行3个item，不反转

        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.HORIZONTAL));// 流式布局,水平方向滚动，有三行

        recyclerView.setAdapter(adapter);





    }

    private void initData() {

        list = new ArrayList<>();

        for (int i = 0; i < 30; i++) {
            list.add(new User(R.mipmap.ic_launcher, "张三" + i));
        }


    }



}
