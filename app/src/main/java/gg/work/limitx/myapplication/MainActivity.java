package gg.work.limitx.myapplication;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import gg.work.limitx.myapplication.dummy.DummyContent;

public class MainActivity extends AppCompatActivity implements
        PlusOneFragment.OnFragmentInteractionListener,
        ItemFragment.OnListFragmentInteractionListener {

    private TextView mTextMessage;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    ItemFragment itemFragment = new ItemFragment();
    PlusOneFragment plusOneFragment = new PlusOneFragment();

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);

                    fragmentTransaction = fragmentManager.beginTransaction();
                    //fragmentTransaction.add(R.id.fragment1, fragment);
                    fragmentTransaction.replace(R.id.fragment1, itemFragment);
                    fragmentTransaction.commit();
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);

                    fragmentTransaction = fragmentManager.beginTransaction();
                    //fragmentTransaction.add(R.id.fragment1, fragment);
                    fragmentTransaction.replace(R.id.fragment1, plusOneFragment);
                    fragmentTransaction.commit();
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    fragmentTransaction = fragmentManager.beginTransaction();
                    //fragmentTransaction.hide(plusOneFragment);
                    //fragmentTransaction.hide(itemFragment);
                    fragmentTransaction.remove(plusOneFragment);
                    fragmentTransaction.remove(itemFragment);
                    fragmentTransaction.commit();
                    return true;

            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }


    Toast toastMessage;

    @Override
    public void onFragmentInteraction(Uri uri) {
        Log.i(this.getPackageName() , "testtt "+ uri);

        if (toastMessage!= null) {
            toastMessage.cancel();
        }
        toastMessage = Toast.makeText(MainActivity.this,"testtt "+ uri,Toast.LENGTH_LONG);
        toastMessage.show();
    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {
        Log.i(this.getPackageName() , "testaaa "+ item.toString());

        if (toastMessage!= null) {
            toastMessage.cancel();
        }
        toastMessage = Toast.makeText(MainActivity.this,"testaaa "+ item.toString(),Toast.LENGTH_LONG);
        toastMessage.show();
    }

}
