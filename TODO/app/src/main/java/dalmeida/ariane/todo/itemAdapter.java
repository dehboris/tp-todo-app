package dalmeida.ariane.todo;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class itemAdapter extends BaseAdapter{
    Context context;
    ArrayList<Todo> item;

    public itemAdapter(Context context, ArrayList<Todo> item) {
        this.context = context;
        this.item= item;
    }

    @Override
    public int getCount() {
        return item.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view;

        if(convertView==null)
        {
            LayoutInflater layoutInflater= LayoutInflater.from(context);
            view = layoutInflater.inflate(R.layout.item_todo,null);
        }

        else
        {
            view=convertView;
        }

        TextView titreTask= (TextView) view.findViewById(R.id.titreTask);
        //get data

        Todo todo=item.get(position);

        titreTask.setText(todo.getNom());
        System.getProperty("line.separator");
        Log.e("name", todo.getNom() + " ");

        return view;

    }

}






