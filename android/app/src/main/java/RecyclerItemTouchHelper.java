import androidx.recyclerview.widget.RecyclerView;

public class RecyclerItemTouchHelper extends ItemTouchHelper.SimpleCallback {

    private RecyclerItemTouchHelperList listener;
    public RecyclerItemTouchHelper(int dragDirs, int swipeDirs){
        super(dragDirs,swipeDirs);
    }
    @Override
    public boolean onMove(RecyclerView recycler View, RecyclerView.ViewHolder viewHolder,RecyclerView.ViewHolder target ){
        return false;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder,int direction){

    }

}
