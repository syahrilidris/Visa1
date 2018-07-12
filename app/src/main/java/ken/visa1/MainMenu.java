package ken.visa1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainMenu extends AppCompatActivity {

    private GridMenuFragment mGridMenuFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        mGridMenuFragment = GridMenuFragment.newInstance(R.drawable.back);

        test();
        setupGridMenu();

        mGridMenuFragment.setOnClickMenuListener(new GridMenuFragment.OnClickMenuListener() {
            @Override
            public void onClickMenu(GridMenu gridMenu, int position) {
                getMonthNumber(position);
            }
        });


    }

    public void viewinfo (View view)
    {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("http://www.tourism.gov.my/"));
        startActivity(intent);
    }

    public int getMonthNumber(int month) {
        int monthNumber = 0;
        switch (month) {
            case 0:
                startActivity(new Intent(MainMenu.this, Registration.class));
                this.finish();
                break;
            case 1:
                startActivity(new Intent(MainMenu.this, TrackStatus.class));
                break;
            case 2:
                startActivity(new Intent(MainMenu.this, Overview.class));
                break;
            case 3:
                startActivity(new Intent(MainMenu.this, VisaInformation.class));
                break;
        }

        return monthNumber;
    }

    private void test()
    {
        FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
        tx.replace(R.id.main_frame, mGridMenuFragment);
        tx.addToBackStack(null);
        tx.commit();
    }

    private void setupGridMenu() {
        List<GridMenu> menus = new ArrayList<>();

        menus.add(new GridMenu("Register", R.drawable.home));
        menus.add(new GridMenu("Track Record", R.drawable.calendar));
        menus.add(new GridMenu("Overview", R.drawable.overview));
        menus.add(new GridMenu("Information", R.drawable.tick));

        mGridMenuFragment.setupMenu(menus);
    }

    @Override
    public void onBackPressed() {
        /*if (0 == getSupportFragmentManager().getBackStackEntryCount()) {
            super.onBackPressed();
        } else {
            getSupportFragmentManager().popBackStack();
        }*/
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
        finish();
        startActivity(new Intent(MainMenu.this, Login.class));

    }
}
