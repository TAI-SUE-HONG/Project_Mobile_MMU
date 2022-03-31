import androidx.recyclerview.widget.RecyclerView;

public interface RecyclerItemTouchHelperList {
    void onSwiped(RecyclerView.ViewHolder viewHolder,int direction,int position);

}
