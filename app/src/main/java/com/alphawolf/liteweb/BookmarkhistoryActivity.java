package com.alphawolf.liteweb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.*;
import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.webkit.*;
import android.animation.*;
import android.view.animation.*;
import java.util.*;
import java.util.regex.*;
import java.text.*;
import org.json.*;
import java.util.ArrayList;
import java.util.HashMap;
import android.widget.LinearLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.Intent;
import android.net.Uri;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.startapp.sdk.*;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;


public class BookmarkhistoryActivity extends  AppCompatActivity  { 
	
	
	private double key = 0;
	private double keys = 0;
	private double position_number = 0;
	private String edit_url = "";
	private String edit_title = "";
	private String title_book = "";
	private String ren_book = "";
	
	private ArrayList<HashMap<String, Object>> list_map = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> hist_map = new ArrayList<>();
	
	private LinearLayout linear1;
	private LinearLayout linear3;
	private LinearLayout linear4;
	private LinearLayout tablayout;
	private LinearLayout linear2;
	private LinearLayout base;
	private LinearLayout trash;
	private LinearLayout main;
	private LinearLayout linear5;
	private ImageView menu_icon;
	private ImageView imageview2;
	private TextView textview1;
	private LinearLayout layout1;
	private LinearLayout layout2;
	private ListView listview1;
	private ListView listview2;
	
	private SharedPreferences sr;
	private SharedPreferences sp;
	private Intent i = new Intent();
	private AlertDialog.Builder d;
	private AlertDialog.Builder dialog_add;
	private AlertDialog.Builder del;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.bookmarkhistory);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		linear4 = (LinearLayout) findViewById(R.id.linear4);
		tablayout = (LinearLayout) findViewById(R.id.tablayout);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		base = (LinearLayout) findViewById(R.id.base);
		trash = (LinearLayout) findViewById(R.id.trash);
		main = (LinearLayout) findViewById(R.id.main);
		linear5 = (LinearLayout) findViewById(R.id.linear5);
		menu_icon = (ImageView) findViewById(R.id.menu_icon);
		imageview2 = (ImageView) findViewById(R.id.imageview2);
		textview1 = (TextView) findViewById(R.id.textview1);
		layout1 = (LinearLayout) findViewById(R.id.layout1);
		layout2 = (LinearLayout) findViewById(R.id.layout2);
		listview1 = (ListView) findViewById(R.id.listview1);
		listview2 = (ListView) findViewById(R.id.listview2);
		sr = getSharedPreferences("sr", Activity.MODE_PRIVATE);
		sp = getSharedPreferences("sp", Activity.MODE_PRIVATE);
		d = new AlertDialog.Builder(this);
		dialog_add = new AlertDialog.Builder(this);
		del = new AlertDialog.Builder(this);
		
		menu_icon.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				PopupMenu pop_up = new PopupMenu(getApplicationContext(), menu_icon);
				Menu menu = pop_up.getMenu();
				menu.add("Clear Bookmarks");
				menu.add("Clear History");
				pop_up.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener(){
					@Override
					public boolean onMenuItemClick(MenuItem item){
						switch (item.getTitle().toString()){
							case "Clear History":
							del.setTitle("Delete");
							del.setMessage("Are you sure you want to delete all Browsing History?\n\n");
							del.setPositiveButton("Clear All", new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface _dialog, int _which) {
									sr.edit().putString(String.valueOf((long)(keys)), new Gson().toJson(hist_map)).commit();
									sr.edit().remove(String.valueOf((long)(keys))).commit();
									_getHistoryData();
								}
							});
							del.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface _dialog, int _which) {
									
								}
							});
							del.create().show();
							break;
							case "Clear Bookmarks":
							del.setTitle("Delete");
							del.setMessage("Are you sure you want to delete all Bookmarks?\n\n");
							del.setPositiveButton("Clear All", new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface _dialog, int _which) {
									sp.edit().putString(String.valueOf((long)(key)), new Gson().toJson(list_map)).commit();
									sp.edit().remove(String.valueOf((long)(key))).commit();
									_getData();
								}
							});
							del.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface _dialog, int _which) {
									
								}
							});
							del.create().show();
							break;}
						return true;
					}
				});
				pop_up.show();
			}
		});
		
		imageview2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				finish();
			}
		});
	}
	
	private void initializeLogic() {
		_getData();
		_getHistoryData();
		viewPager = new androidx.viewpager.widget.ViewPager(this); viewPager.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)); MyPagerAdapter adapter = new MyPagerAdapter(); viewPager.setAdapter(adapter); viewPager.setCurrentItem(0); 
		
		base.
		
		addView(viewPager); viewPager.addOnPageChangeListener(new androidx.viewpager.widget.ViewPager.OnPageChangeListener() { public void onPageSelected(int position) { position_number = position; 
				if (position_number == 0) {
					
				}
				else {
					if (position_number == 1) {
						
					}
				}
			} @Override public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) { } @Override public void onPageScrollStateChanged(int state) { } }); tabLayout = new com.google.android.material.tabs.TabLayout(this); tabLayout.setTabGravity(tabLayout.GRAVITY_FILL); tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#2196F3")); tabLayout.setTabTextColors(Color.parseColor("#FF596067"), Color.parseColor("#FF7F7F7F"));
		
		 tabLayout.setupWithViewPager(viewPager); tablayout.addView(tabLayout); } private class MyPagerAdapter extends androidx.viewpager.widget.PagerAdapter { public int getCount() { return
			
			 2
			
			
			
			; } @Override public Object instantiateItem(ViewGroup collection, int position)
		
		
		 {
			
			LayoutInflater inflater = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View v = inflater.inflate(R.layout.empty, null);
			
			LinearLayout container = (LinearLayout) v.findViewById(R.id.linear1);
			
			if (position == 0) {
				ViewGroup parent = (ViewGroup) layout1.getParent();
				if (parent != null) {
					parent.removeView(layout1);
				}container.addView(layout1);}
			
			
			
			else if (position == 1) {
				ViewGroup parent = (ViewGroup) layout2.getParent();
				if (parent != null) {
					parent.removeView(layout2);
				}container.addView(layout2);}
			
			
			
			
			collection.addView(v, 0);
			return v;
		}
		@Override public void destroyItem(ViewGroup collection, int position, Object view) {
			collection.removeView((View) view);
			trash.addView((View) view);
		}
		@Override public CharSequence getPageTitle(int position) {
			switch (position) {
				
				
				
				
				
				case 0:
				return "Bookmarks";
				
				case 1:
				return "History";
				
				
				default:
				return null;
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		@Override public boolean isViewFromObject(View arg0, Object arg1) { return arg0 == ((View) arg1);} @Override public Parcelable saveState() { return null; } } androidx.viewpager.widget.ViewPager viewPager; com.google.android.material.tabs.TabLayout tabLayout; private void foo() {
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	@Override
	public void onResume() {
		super.onResume();
		_getData();
		_getHistoryData();
	}
	
	@Override
	public void onBackPressed() {
		sp.edit().putString(String.valueOf((long)(key)), new Gson().toJson(list_map)).commit();
		sr.edit().putString(String.valueOf((long)(keys)), new Gson().toJson(hist_map)).commit();
		finish();
	}
	public void _getData () {
		list_map.clear();
		if (!sp.getString(String.valueOf((long)(key)), "").equals("")) {
			list_map = new Gson().fromJson(sp.getString(String.valueOf((long)(key)), ""), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
		}
		listview1.setAdapter(new Listview1Adapter(list_map));
		((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
	}
	
	
	public void _getHistoryData () {
		hist_map.clear();
		if (!sr.getString(String.valueOf((long)(keys)), "").equals("")) {
			hist_map = new Gson().fromJson(sr.getString(String.valueOf((long)(keys)), ""), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
		}
		listview2.setAdapter(new Listview2Adapter(hist_map));
		((BaseAdapter)listview2.getAdapter()).notifyDataSetChanged();
	}
	
	
	public void _setRoundCorner (final View _view, final String _color, final double _radius) {
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
		
		gd.setColor(Color.parseColor(_color));
		
		gd.setCornerRadius((int)_radius);
		_view.setBackground(gd);
	}
	
	
	public class Listview1Adapter extends BaseAdapter {
		ArrayList<HashMap<String, Object>> _data;
		public Listview1Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public int getCount() {
			return _data.size();
		}
		
		@Override
		public HashMap<String, Object> getItem(int _index) {
			return _data.get(_index);
		}
		
		@Override
		public long getItemId(int _index) {
			return _index;
		}
		@Override
		public View getView(final int _position, View _v, ViewGroup _container) {
			LayoutInflater _inflater = (LayoutInflater)getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View _view = _v;
			if (_view == null) {
				_view = _inflater.inflate(R.layout.listc, null);
			}
			
			final LinearLayout linear1 = (LinearLayout) _view.findViewById(R.id.linear1);
			final LinearLayout linear3 = (LinearLayout) _view.findViewById(R.id.linear3);
			final LinearLayout linear2 = (LinearLayout) _view.findViewById(R.id.linear2);
			final LinearLayout linear4 = (LinearLayout) _view.findViewById(R.id.linear4);
			final TextView textview1 = (TextView) _view.findViewById(R.id.textview1);
			final TextView textview2 = (TextView) _view.findViewById(R.id.textview2);
			final TextView textview3 = (TextView) _view.findViewById(R.id.textview3);
			final ImageView menu = (ImageView) _view.findViewById(R.id.menu);
			
			_setRoundCorner(textview1, "#FF787878", 90);
			_setRoundCorner(linear3, "#FFF1F3F4", 90);
			if (_data.get((int)_position).containsKey("title")) {
				textview1.setText(list_map.get((int)_position).get("title").toString().substring((int)(0), (int)(1)));
				textview2.setText(_data.get((int)_position).get("title").toString());
			}
			if (_data.get((int)_position).containsKey("url")) {
				textview3.setText(_data.get((int)_position).get("url").toString());
			}
			linear2.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					i.setClass(getApplicationContext(), BrowseActivity.class);
					i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					if (_data.get((int)_position).containsKey("url")) {
						i.putExtra("intenturl", _data.get((int)_position).get("url").toString());
					}
					startActivity(i);
				}
			});
			menu.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					PopupMenu popup = new PopupMenu(getApplicationContext(), menu);
					Menu menu = popup.getMenu();
					menu.add("Edit");
					menu.add("Delete");
					popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener(){
						@Override
						public boolean onMenuItemClick(MenuItem item){
							switch (item.getTitle().toString()){
								case "Edit":
								dialog_add.setTitle("Edit");
								edit_title = _data.get((int)_position).get("title").toString();
								edit_url = _data.get((int)_position).get("url").toString();
								final EditText dialog_edittext1 = new EditText(BookmarkhistoryActivity.this);
								dialog_edittext1.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
								dialog_edittext1.setHint("Title");
								dialog_edittext1.setText(edit_title);
								
								final EditText dialog_edittext2 = new EditText(BookmarkhistoryActivity.this);
								dialog_edittext2.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
								dialog_edittext2.setHint("Enter URL");
								dialog_edittext2.setText(edit_url);
								
								View inflated_view = getLayoutInflater().inflate(R.layout.dialog_view, null);
								
								LinearLayout dialog_linear1 = inflated_view.findViewById(R.id.linear2);
								LinearLayout dialog_linear2 = inflated_view.findViewById(R.id.linear3);
								
								dialog_linear1.addView(dialog_edittext1);
								dialog_linear2.addView(dialog_edittext2);
								dialog_add.setView(inflated_view);
								dialog_add.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
									@Override
									public void onClick(DialogInterface _dialog, int _which) {
										title_book = dialog_edittext1.getText().toString();
										ren_book = dialog_edittext2.getText().toString();
										_data.get((int)_position).put("title", title_book);
										_data.get((int)_position).put("url", ren_book);
										sp.edit().putString(String.valueOf((long)(key)), new Gson().toJson(list_map)).commit();
										_getData();
									}
								});
								dialog_add.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
									@Override
									public void onClick(DialogInterface _dialog, int _which) {
										
									}
								});
								dialog_add.create().show();
								break;
								case "Delete":
								d.setTitle("Delete");
								d.setMessage("Are you sure you want to delete this Bookmark?\n\nThis action cannot be undone.");
								d.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
									@Override
									public void onClick(DialogInterface _dialog, int _which) {
										list_map.remove((int)(_position));
										sp.edit().putString(String.valueOf((long)(key)), new Gson().toJson(list_map)).commit();
										_getData();
									}
								});
								d.setNegativeButton("No", new DialogInterface.OnClickListener() {
									@Override
									public void onClick(DialogInterface _dialog, int _which) {
										
									}
								});
								d.setNeutralButton("Clear All", new DialogInterface.OnClickListener() {
									@Override
									public void onClick(DialogInterface _dialog, int _which) {
										sp.edit().putString(String.valueOf((long)(key)), new Gson().toJson(list_map)).commit();
										sp.edit().remove(String.valueOf((long)(key))).commit();
										_getData();
									}
								});
								d.create().show();
								break;}
							return true;
						}
					});
					popup.show();
				}
			});
			
			return _view;
		}
	}
	
	public class Listview2Adapter extends BaseAdapter {
		ArrayList<HashMap<String, Object>> _data;
		public Listview2Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public int getCount() {
			return _data.size();
		}
		
		@Override
		public HashMap<String, Object> getItem(int _index) {
			return _data.get(_index);
		}
		
		@Override
		public long getItemId(int _index) {
			return _index;
		}
		@Override
		public View getView(final int _position, View _v, ViewGroup _container) {
			LayoutInflater _inflater = (LayoutInflater)getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View _view = _v;
			if (_view == null) {
				_view = _inflater.inflate(R.layout.listc, null);
			}
			
			final LinearLayout linear1 = (LinearLayout) _view.findViewById(R.id.linear1);
			final LinearLayout linear3 = (LinearLayout) _view.findViewById(R.id.linear3);
			final LinearLayout linear2 = (LinearLayout) _view.findViewById(R.id.linear2);
			final LinearLayout linear4 = (LinearLayout) _view.findViewById(R.id.linear4);
			final TextView textview1 = (TextView) _view.findViewById(R.id.textview1);
			final TextView textview2 = (TextView) _view.findViewById(R.id.textview2);
			final TextView textview3 = (TextView) _view.findViewById(R.id.textview3);
			final ImageView menu = (ImageView) _view.findViewById(R.id.menu);
			
			_setRoundCorner(textview1, "#FF787878", 90);
			_setRoundCorner(linear3, "#FFF1F3F4", 90);
			if (_data.get((int)_position).containsKey("title")) {
				textview1.setText(_data.get((int)_position).get("title").toString().substring((int)(0), (int)(1)));
				textview2.setText(_data.get((int)_position).get("title").toString());
			}
			if (_data.get((int)_position).containsKey("url")) {
				textview3.setText(_data.get((int)_position).get("url").toString());
			}
			linear2.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					i.setClass(getApplicationContext(), BrowseActivity.class);
					i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					if (_data.get((int)_position).containsKey("url")) {
						i.putExtra("intenturl", _data.get((int)_position).get("url").toString());
					}
					startActivity(i);
				}
			});
			menu.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					PopupMenu popup = new PopupMenu(getApplicationContext(), menu);
					Menu menu = popup.getMenu();
					menu.add("Delete");
					popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener(){
						@Override
						public boolean onMenuItemClick(MenuItem item){
							switch (item.getTitle().toString()){
								case "Delete":
								d.setTitle("Delete");
								d.setMessage("Are you sure you want to delete this History?\n\nThis action cannot be undone.");
								d.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
									@Override
									public void onClick(DialogInterface _dialog, int _which) {
										hist_map.remove((int)(_position));
										sr.edit().putString(String.valueOf((long)(keys)), new Gson().toJson(hist_map)).commit();
										_getHistoryData();
									}
								});
								d.setNegativeButton("No", new DialogInterface.OnClickListener() {
									@Override
									public void onClick(DialogInterface _dialog, int _which) {
										
									}
								});
								d.setNeutralButton("Clear All", new DialogInterface.OnClickListener() {
									@Override
									public void onClick(DialogInterface _dialog, int _which) {
										sr.edit().putString(String.valueOf((long)(keys)), new Gson().toJson(hist_map)).commit();
										sr.edit().remove(String.valueOf((long)(keys))).commit();
										_getHistoryData();
									}
								});
								d.create().show();
								break;}
							return true;
						}
					});
					popup.show();
				}
			});
			
			return _view;
		}
	}
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input){
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels(){
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels(){
		return getResources().getDisplayMetrics().heightPixels;
	}
	
}