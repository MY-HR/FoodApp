package com.example.foodapp;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener{

	//�������� Food ��list
	
	private ViewPager mViewPager;// �������ý����л�
	private PagerAdapter mPagerAdapter;// ��ʼ��View������
	private List<View> mViews = new ArrayList<View>();// �����������ҳ��
	private TextView topView;
	
	// ��ȡ����
	private Button btnHome;
	private Button btnMenu;
	private Button btnCheck;
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        
        initView();
        initViewPage();
        initEvent();
    }
    
    private void initEvent() { 	
    	// 	����app ����ҳ��Ϊ home ��ҳ
    	mViewPager.setCurrentItem(1);
    	btnHome.setTextSize(22);
    	topView.setText("��ҳ");
    	
    	//	���õײ��ؼ��ļ����¼�
    	btnMenu.setOnClickListener(this);
    	btnHome.setOnClickListener(this);
    	btnCheck.setOnClickListener(this);   	
    	mViewPager.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int arg0) {
				int currentItem = mViewPager.getCurrentItem();
				switch (currentItem) {
				case 0:
					resetBtn();
					btnMenu.setTextSize(22);
					topView.setText("�˵�����");
					break;
				case 1:
					resetBtn();
					btnHome.setTextSize(22);
					topView.setText("��ҳ");
					break;
				case 2:
					resetBtn();
					btnCheck.setTextSize(22);
					topView.setText("�˵�");
					break;
				default:
					break;
				}
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				
			}
		});
    	
    }
    
    /**
	 * ��ʼ������
	 */
    private void initView() {
		mViewPager = (ViewPager) findViewById(R.id.main_viewpager);
		// ��ʼ���ĸ���ť
		btnMenu = (Button) findViewById(R.id.menu_button);
		btnHome = (Button) findViewById(R.id.home_button);
		btnCheck = (Button) findViewById(R.id.check_button);
		//��ȡ��������textView
		topView =  (TextView) findViewById(R.id.top_layout_name);
	}
    
    /**
	 * ��ʼ��ViewPage
	 */
    private void initViewPage() {
		// ��ʼ����������
		LayoutInflater mLayoutInflater = LayoutInflater.from(this);
		View menu = mLayoutInflater.inflate(R.layout.menu, null);
		View home = mLayoutInflater.inflate(R.layout.home_fragment, null);
		View check= mLayoutInflater.inflate(R.layout.check, null);
		
		mViews.add(menu);
		mViews.add(home);
		mViews.add(check);

		// ��������ʼ��������
		mPagerAdapter = new PagerAdapter() {

			@Override
			public void destroyItem(ViewGroup container, int position,
					Object object) {
				container.removeView(mViews.get(position));
			}

			@Override
			public Object instantiateItem(ViewGroup container, int position) {
				View view = mViews.get(position);
				container.addView(view);
				return view;
			}

			@Override
			public boolean isViewFromObject(View arg0, Object arg1) {
				return arg0 == arg1;
			}

			@Override
			public int getCount() {
				return mViews.size();
			}
		};
		mViewPager.setAdapter(mPagerAdapter);
	}

    


	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.menu_button:
			mViewPager.setCurrentItem(0);
			resetBtn();
			btnMenu.setTextSize(22);
			topView.setText("�˵�����");
			break;
		case R.id.home_button:
			mViewPager.setCurrentItem(1);
			resetBtn();
			btnHome.setTextSize(22);
			topView.setText("��ҳ");
			break;
		case R.id.check_button:
			mViewPager.setCurrentItem(2);
			resetBtn();
			btnCheck.setTextSize(22);
			topView.setText("�˵�");
			break;
		default :
				break;
		}
	}
	
	/**
	 * �����а�������
	 */
	private void resetBtn() {
		btnCheck.setTextSize(18);
		btnHome.setTextSize(18);
		btnMenu.setTextSize(18);
	}
    
}
