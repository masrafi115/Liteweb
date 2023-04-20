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
import android.widget.LinearLayout;
import android.widget.ImageView;
import android.widget.EditText;
import android.widget.TextView;
import android.app.Activity;
import android.content.SharedPreferences;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.graphics.Typeface;
import com.startapp.sdk.*;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;


public class MainActivity extends  AppCompatActivity  { 
	
	
	private String item_ = "";
	private double wh_ = 0;
	private double keys = 0;
	
	private ArrayList<String> search_list = new ArrayList<>();
	
	private LinearLayout linear18;
	private LinearLayout linear1;
	private LinearLayout indicator;
	private LinearLayout bottom_container;
	private LinearLayout linear2;
	private LinearLayout linear6;
	private LinearLayout linear17;
	private LinearLayout linear5;
	private ImageView imageview30;
	private EditText edittext1;
	private ImageView imageview15;
	private LinearLayout linear7;
	private LinearLayout linear8;
	private LinearLayout linear9;
	private LinearLayout linear10;
	private LinearLayout linear11;
	private LinearLayout linear12;
	private TextView textview4;
	private ImageView imageview17;
	private LinearLayout linear13;
	private TextView textview3;
	private ImageView imageview19;
	private LinearLayout linear14;
	private TextView textview6;
	private ImageView imageview20;
	private LinearLayout linear15;
	private TextView textview7;
	private ImageView imageview23;
	private LinearLayout linear16;
	private TextView textview8;
	private ImageView imageview29;
	private ImageView back;
	private ImageView forward;
	private ImageView menu;
	private ImageView home;
	private ImageView tab;
	
	private SharedPreferences night;
	private AlertDialog.Builder search;
	private SharedPreferences Searcher;
	private AlertDialog.Builder exitt;
	private Intent i = new Intent();
	private SharedPreferences save;
	private SharedPreferences setting;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		
		linear18 = (LinearLayout) findViewById(R.id.linear18);
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		indicator = (LinearLayout) findViewById(R.id.indicator);
		bottom_container = (LinearLayout) findViewById(R.id.bottom_container);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		linear6 = (LinearLayout) findViewById(R.id.linear6);
		linear17 = (LinearLayout) findViewById(R.id.linear17);
		linear5 = (LinearLayout) findViewById(R.id.linear5);
		imageview30 = (ImageView) findViewById(R.id.imageview30);
		edittext1 = (EditText) findViewById(R.id.edittext1);
		imageview15 = (ImageView) findViewById(R.id.imageview15);
		linear7 = (LinearLayout) findViewById(R.id.linear7);
		linear8 = (LinearLayout) findViewById(R.id.linear8);
		linear9 = (LinearLayout) findViewById(R.id.linear9);
		linear10 = (LinearLayout) findViewById(R.id.linear10);
		linear11 = (LinearLayout) findViewById(R.id.linear11);
		linear12 = (LinearLayout) findViewById(R.id.linear12);
		textview4 = (TextView) findViewById(R.id.textview4);
		imageview17 = (ImageView) findViewById(R.id.imageview17);
		linear13 = (LinearLayout) findViewById(R.id.linear13);
		textview3 = (TextView) findViewById(R.id.textview3);
		imageview19 = (ImageView) findViewById(R.id.imageview19);
		linear14 = (LinearLayout) findViewById(R.id.linear14);
		textview6 = (TextView) findViewById(R.id.textview6);
		imageview20 = (ImageView) findViewById(R.id.imageview20);
		linear15 = (LinearLayout) findViewById(R.id.linear15);
		textview7 = (TextView) findViewById(R.id.textview7);
		imageview23 = (ImageView) findViewById(R.id.imageview23);
		linear16 = (LinearLayout) findViewById(R.id.linear16);
		textview8 = (TextView) findViewById(R.id.textview8);
		imageview29 = (ImageView) findViewById(R.id.imageview29);
		back = (ImageView) findViewById(R.id.back);
		forward = (ImageView) findViewById(R.id.forward);
		menu = (ImageView) findViewById(R.id.menu);
		home = (ImageView) findViewById(R.id.home);
		tab = (ImageView) findViewById(R.id.tab);
		night = getSharedPreferences("night", Activity.MODE_PRIVATE);
		search = new AlertDialog.Builder(this);
		Searcher = getSharedPreferences("Searcher", Activity.MODE_PRIVATE);
		exitt = new AlertDialog.Builder(this);
		save = getSharedPreferences("save", Activity.MODE_PRIVATE);
		setting = getSharedPreferences("setting", Activity.MODE_PRIVATE);
		
		imageview30.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				search.setTitle("Default Search Engine");
				search.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						SketchwareUtil.showMessage(getApplicationContext(), item_);
						if (item_.equals("Google")) {
							Searcher.edit().putString("search", "Google").commit();
							_Search_engine();
						}
						if (item_.equals("Naver")) {
							Searcher.edit().putString("search", "Naver").commit();
							_Search_engine();
						}
						if (item_.equals("Duckduckgo")) {
							Searcher.edit().putString("search", "DuckDuckGo").commit();
							_Search_engine();
						}
						if (item_.equals("Yahoo")) {
							Searcher.edit().putString("search", "Yahoo").commit();
							_Search_engine();
						}
					}
				});
				_Single_Choice_Dialog(search, search_list);
				search.create().show();
			}
		});
		
		imageview15.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (edittext1.getText().toString().contains("https://") || edittext1.getText().toString().contains("http://")) {
					i.setClass(getApplicationContext(), BrowseActivity.class);
					i.putExtra("intenturl", edittext1.getText().toString());
					startActivity(i);
				}
				else {
					if (edittext1.getText().toString().contains(".")) {
						i.setClass(getApplicationContext(), BrowseActivity.class);
						i.putExtra("intenturl", "http://".concat(edittext1.getText().toString()));
						startActivity(i);
					}
					else {
						if (Searcher.getString("search", "").equals("Google")) {
							i.setClass(getApplicationContext(), BrowseActivity.class);
							i.putExtra("intenturl", "https://www.google.com/search?q=".concat(edittext1.getText().toString()));
							startActivity(i);
						}
						if (Searcher.getString("search", "").equals("Naver")) {
							i.setClass(getApplicationContext(), BrowseActivity.class);
							i.putExtra("intenturl", "https://search.naver.com/search.naver?&query=".concat(edittext1.getText().toString()));
							startActivity(i);
						}
						if (Searcher.getString("search", "").equals("DuckDuckGo")) {
							i.setClass(getApplicationContext(), BrowseActivity.class);
							i.putExtra("intenturl", "https://duckduckgo.com/?q=".concat(edittext1.getText().toString()));
							startActivity(i);
						}
						if (Searcher.getString("search", "").equals("Yahoo")) {
							i.setClass(getApplicationContext(), BrowseActivity.class);
							i.putExtra("intenturl", "https://search.yahoo.com/search?p=".concat(edittext1.getText().toString()));
							startActivity(i);
						}
						if (Searcher.getString("search", "").equals("")) {
							i.setClass(getApplicationContext(), BrowseActivity.class);
							i.putExtra("intenturl", "https://www.google.com/search?q=".concat(edittext1.getText().toString()));
							startActivity(i);
						}
					}
				}
			}
		});
		
		linear7.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), BrowseActivity.class);
				i.putExtra("intenturl", "https://m.youtube.com/");
				startActivity(i);
			}
		});
		
		linear8.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), BrowseActivity.class);
				i.putExtra("intenturl", "https://www.facebook.com/");
				startActivity(i);
			}
		});
		
		linear9.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), BrowseActivity.class);
				i.putExtra("intenturl", "https://www.amazon.com/");
				startActivity(i);
			}
		});
		
		linear10.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), BrowseActivity.class);
				i.putExtra("intenturl", "https://twitter.com/");
				startActivity(i);
			}
		});
		
		linear11.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), BrowseActivity.class);
				i.putExtra("intenturl", "https://www.instagram.com/");
				startActivity(i);
			}
		});
		
		menu.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				final com.google.android.material.bottomsheet.BottomSheetDialog bottomSheetDialog = new com.google.android.material.bottomsheet.BottomSheetDialog(MainActivity.this);
				
				View bottomSheetView; bottomSheetView = getLayoutInflater().inflate(R.layout.bottom_sheet_p2,null );
				bottomSheetDialog.setContentView(bottomSheetView);
				
				bottomSheetDialog.getWindow().findViewById(R.id.design_bottom_sheet).setBackgroundResource(android.R.color.transparent);
				LinearLayout bg = (LinearLayout) bottomSheetView.findViewById(R.id.bg);
				
				ImageView close = (ImageView) bottomSheetView.findViewById(R.id.imageview37);
				
				ImageView open_settings = (ImageView) bottomSheetView.findViewById(R.id.imageview38);
				
				ImageView exit = (ImageView) bottomSheetView.findViewById(R.id.imageview36);
				
				ImageView view_books = (ImageView) bottomSheetView.findViewById(R.id.imageview17);
				
				ImageView downloads_file = (ImageView) bottomSheetView.findViewById(R.id.imageview19);
				
				ImageView incognito_img = (ImageView) bottomSheetView.findViewById(R.id.imageview31);
				
				ImageView block_image  = (ImageView) bottomSheetView.findViewById(R.id.imageview20);
				
				_rippleRoundStroke(bg, "#FFFFFF", "#000000", 15, 0, "#000000");
				if (setting.getString("block_img", "").equals("t")) {
					block_image.setImageResource(R.drawable.block_img_mode);
				}
				else {
					if (setting.getString("block_img", "").equals("f")) {
						setting.edit().putString("block_img", "f").commit();
						block_image.setImageResource(R.drawable.no_image);
					}
				}
				block_image.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){
						bottomSheetDialog.dismiss();
						if (setting.getString("block_img", "").equals("t")) {
							setting.edit().putString("block_img", "f").commit();
						}
						else {
							setting.edit().putString("block_img", "t").commit();
						}
					}});
				if (setting.getString("incognito_web", "").equals("t")) {
					incognito_img.setImageResource(R.drawable.incognito_on_mode);
				}
				else {
					if (setting.getString("incognito_web", "").equals("f")) {
						setting.edit().putString("incognito_web", "f").commit();
						incognito_img.setImageResource(R.drawable.incognito_mode);
					}
				}
				incognito_img.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){
						bottomSheetDialog.dismiss();
						if (setting.getString("incognito_web", "").equals("t")) {
							setting.edit().putString("incognito_web", "f").commit();
						}
						else {
							setting.edit().putString("incognito_web", "t").commit();
						}
					}});
				close.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){
						bottomSheetDialog.dismiss();
					}});
				open_settings.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){
						bottomSheetDialog.dismiss();
						i.setClass(getApplicationContext(), SettingActivity.class);
						startActivity(i);
					}});
				view_books.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){
						bottomSheetDialog.dismiss();
						i.setClass(getApplicationContext(), BookmarkhistoryActivity.class);
						startActivity(i);
					}});
				downloads_file.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){
						bottomSheetDialog.dismiss();
						startActivity(new Intent(DownloadManager.ACTION_VIEW_DOWNLOADS));
					}});
				exit.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){
						bottomSheetDialog.dismiss();
						_finish();
					}});
				bottomSheetDialog.setCancelable(true);
				bottomSheetDialog.show();
			}
		});
	}
	
	private void initializeLogic() {
		edittext1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/roboto_regular.ttf"), 0);
		textview4.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/roboto_regular.ttf"), 0);
		textview3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/roboto_regular.ttf"), 0);
		textview6.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/roboto_regular.ttf"), 0);
		textview7.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/roboto_regular.ttf"), 0);
		textview8.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/roboto_regular.ttf"), 0);
		if (setting.getString("savelink", "").equals("t")) {
			if (save.getString("save", "").equals("")) {
				i.setClass(getApplicationContext(), BrowseActivity.class);
				i.putExtra("intenturl", "https://www.google.com");
				startActivity(i);
			}
			else {
				i.setClass(getApplicationContext(), BrowseActivity.class);
				i.putExtra("intenturl", save.getString("save", ""));
				startActivity(i);
			}
		}
		else {
			
		}
		android.graphics.drawable.GradientDrawable mc = new android.graphics.drawable.GradientDrawable();
		mc.setColor(Color.parseColor("#FFE1E4E4"));
		mc.setCornerRadius(40);
		linear5.setBackground(mc);
		search_list.add("Google");
		search_list.add("Duckduckgo");
		search_list.add("Yahoo");
		search_list.add("Naver");
		_Search_engine();
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
	public void onBackPressed() {
		exitt.setTitle("Exit");
		exitt.setMessage("Do you want to exit ?");
		exitt.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface _dialog, int _which) {
				finish();
			}
		});
		exitt.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface _dialog, int _which) {
				
			}
		});
		exitt.create().show();
	}
	
	@Override
	public void onResume() {
		super.onResume();
		_Search_engine();
	}
	public void _Single_Choice_Dialog (final AlertDialog.Builder _dialog, final ArrayList<String> _list) {
		final CharSequence[] _items = _list.toArray(new String[_list.size()]);
		_dialog.setSingleChoiceItems(_items, -1, new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				wh_ = which;
				item_ = _list.get((int)(wh_));
				
			}});
	}
	
	
	public void _nightmode () {
		night.edit().putString("nm", "on").commit();
	}
	
	
	public void _Search_engine () {
		if (Searcher.getString("search", "").equals("Google")) {
			Searcher.edit().putString("search", "Google").commit();
			imageview30.setImageResource(R.drawable.google);
		}
		if (Searcher.getString("search", "").equals("Naver")) {
			Searcher.edit().putString("search", "Naver").commit();
			imageview30.setImageResource(R.drawable.naver_logo);
		}
		if (Searcher.getString("search", "").equals("DuckDuckGo")) {
			Searcher.edit().putString("search", "DuckDuckGo").commit();
			imageview30.setImageResource(R.drawable.duckduckgo_logo);
		}
		if (Searcher.getString("search", "").equals("Yahoo")) {
			Searcher.edit().putString("search", "Yahoo").commit();
			imageview30.setImageResource(R.drawable.yahoo_logo);
		}
	}
	
	
	public void _rippleRoundStroke (final View _view, final String _focus, final String _pressed, final double _round, final double _stroke, final String _strokeclr) {
		android.graphics.drawable.GradientDrawable GG = new android.graphics.drawable.GradientDrawable();
		GG.setColor(Color.parseColor(_focus));
		GG.setCornerRadius((float)_round);
		GG.setStroke((int) _stroke,
		Color.parseColor("#" + _strokeclr.replace("#", "")));
		android.graphics.drawable.RippleDrawable RE = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor(_pressed)}), GG, null);
		_view.setBackground(RE);
	}
	
	
	public void _finish () {
		finish();
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