package qianfeng.a7_2recyclerview1;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2016/10/9 0009.
 */
public class MyAdapter extends RecyclerView.Adapter {

    private Context context;
    private LayoutInflater inflater;
    private List<User> list;

    public MyAdapter(Context context, List<User> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    // 创建holder，相当于ListView中getView的if(){}else{}
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // 它里面会自己进行ListView中的if(){}else{}的判断
        View view = inflater.inflate(R.layout.recyclerview_item, parent, false);
        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }

    // 给holder中的控件赋值
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        // 记得强转啊！卧槽
        MyHolder myHolder = (MyHolder) holder;
        User user = list.get(position);
        myHolder.iv.setImageResource(user.getUserface());
        myHolder.tv.setText(user.getUsername());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {
        private ImageView iv;
        private TextView tv;

        public MyHolder(View itemView) {
            super(itemView);
            iv = (ImageView) itemView.findViewById(R.id.iv);
            tv = (TextView) itemView.findViewById(R.id.tv);
        }
    }


}
