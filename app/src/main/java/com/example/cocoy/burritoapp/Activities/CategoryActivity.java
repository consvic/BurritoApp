package com.example.cocoy.burritoapp.Activities;

import android.app.ActionBar;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.cocoy.burritoapp.Category;
import com.example.cocoy.burritoapp.R;
import com.example.cocoy.burritoapp.Adapters.RecyclerViewClickListener;
import com.example.cocoy.burritoapp.Adapters.RecyclerViewCustomAdapter;

import java.util.ArrayList;

public class CategoryActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;

    private RecyclerViewClickListener listener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        //getActionBar().setDisplayHomeAsUpEnabled(true);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewCategory);
        /*
            Un LayoutManager es el responsable de medir y saber la posición de los elementos dentro
            de un RecyclerView, así como determinar el momento en que los elementos se ocultan y muestran
         */
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        ArrayList<Category> categories = new ArrayList<Category>();
        categories.add(new Category("Calientes", R.mipmap.donut_icon));
        categories.add(new Category("Postres", R.mipmap.pretzel_icon));
        categories.add(new Category("Frios", R.mipmap.sandwich_icon));
        categories.add(new Category("Bebidas", R.mipmap.tea_icon));


        // TODO: 13.- Ingresamos a nuestro adaptador un nuevo listener para poder saber el elemento al que se le dio click
        RecyclerViewCustomAdapter adapter = new RecyclerViewCustomAdapter(categories, new RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                Toast.makeText(CategoryActivity.this, "Elemento " + position, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(CategoryActivity.this,ItemsActivity.class);
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(adapter);

    }

    /*@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }*/

    /**
     * RecyclerView item decoration - give equal margin around grid item
     */
    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
}
