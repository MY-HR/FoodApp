package com.example.foodapp;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.LinearLayout.LayoutParams;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

public class HomeFragment extends Fragment{
	private Activity activity;
	//初始化viewpager
	private ViewPager mViewPager;
	private List<ImageView> mlist;
	private LinearLayout mLinearLayout;

	// 存储图片
	private int[] bannerImages = { R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4 };

	// ViewPager	广告
	private BannerAdapter mAdapter;
	private BannerListener bannerListener;

	// 设置点
	private int pointIndex = 0;
	private boolean isStop = false;

	/*	ListView   */
	private View view;
	private List<Food> foods = new ArrayList<Food>(); 
	private FoodAdapterMain adapterMain;
	private ListView listView;
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		this.activity = activity;

	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {	
		view = inflater.inflate(R.layout.home, container, false);
		initView();
		initData();
		initAction();
		initFoods();
		// ��������� adapter
		adapterMain = new FoodAdapterMain(activity, R.layout.food_item_main, foods);
        listView.setAdapter(adapterMain);

		// 设置广告4秒自动过
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (!isStop) {
					SystemClock.sleep(4000);
					activity.runOnUiThread(new Runnable() {
						@Override
						public void run() {
							mViewPager.setCurrentItem(mViewPager.getCurrentItem() + 1);
						}
					});
				}
			}
		}).start();
		
		return view;
	}
	
	//手动给数据，暂时用着
    private void initFoods() {
		Food shengCai = new Food("大白菜", R.drawable.ic_launcher);
		foods.add(shengCai);
		Food daBaiCai = new Food("大白菜", R.drawable.ic_launcher);
		foods.add(daBaiCai);
		Food aa = new Food("大白菜", R.drawable.ic_launcher);
		foods.add(aa);
		Food bb = new Food("大白菜", R.drawable.ic_launcher);
		foods.add(bb);
		Food cc = new Food("大白菜", R.drawable.ic_launcher);
		foods.add(cc);
		Food dd = new Food("大白菜", R.drawable.ic_launcher);
		foods.add(dd);
	}

	private void initAction() {
		bannerListener = new BannerListener();
		mViewPager.setOnPageChangeListener(bannerListener);

		int index = (Integer.MAX_VALUE / 2) - (Integer.MAX_VALUE / 2 % mlist.size());

		mViewPager.setCurrentItem(index);
		mLinearLayout.getChildAt(pointIndex).setEnabled(true);
	}


	private void initData() {
		mlist = new ArrayList<ImageView>();
		View view;
		LayoutParams params;
		for (int i = 0; i < bannerImages.length; i++) {

			ImageView imageView = new ImageView(activity);
			imageView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
			imageView.setBackgroundResource(bannerImages[i]);
			mlist.add(imageView);

			view = new View(activity);
			params = new LayoutParams(5, 5);
			params.leftMargin = 10;
			view.setBackgroundResource(R.drawable.point_background);
			view.setLayoutParams(params);
			view.setEnabled(false);

			mLinearLayout.addView(view);
		}
		mAdapter = new BannerAdapter(mlist);
		mViewPager.setAdapter(mAdapter);
	}

	/**
	 *
	 */
	private void initView() {
		mViewPager = (ViewPager) view.findViewById(R.id.ad_viewpager);
		mLinearLayout = (LinearLayout) view.findViewById(R.id.points);
		listView = (ListView) view.findViewById(R.id.listview);
	}

	class BannerListener implements ViewPager.OnPageChangeListener {

		@Override
		public void onPageScrollStateChanged(int arg0) {
		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
		}

		@Override
		public void onPageSelected(int position) {
			int newPosition = position % bannerImages.length;
			mLinearLayout.getChildAt(newPosition).setEnabled(true);
			mLinearLayout.getChildAt(pointIndex).setEnabled(false);

			pointIndex = newPosition;

		}

	}

	@Override
	public void onDestroy() {

		isStop = true;
		super.onDestroy();
	}

	public class BannerAdapter extends PagerAdapter {

		private List<ImageView> mList;

		public BannerAdapter(List<ImageView> list) {
			this.mList = list;
		}

		@Override
		public int getCount() {
			return Integer.MAX_VALUE;
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			container.addView(mList.get(position%mList.size()));
			return mList.get(position%mList.size());
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			container.removeView(mList.get(position%mList.size()));
		}

	}
}
