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
import android.widget.TextView;
import android.widget.Switch;
import java.util.Timer;
import java.util.TimerTask;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.Intent;
import android.net.Uri;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.CompoundButton;
import android.graphics.Typeface;
import com.startapp.sdk.*;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;


public class SettingActivity extends  AppCompatActivity  { 
	
	private Timer _timer = new Timer();
	
	private String data = "";
	private String hm = "";
	private double number = 0;
	private String defc = "";
	private String defrepc = "";
	private String repc = "";
	private String color = "";
	private String item_ = "";
	private double wh_ = 0;
	private double n1 = 0;
	private double n2 = 0;
	private double keys = 0;
	
	private ArrayList<String> search_list = new ArrayList<>();
	private ArrayList<String> li = new ArrayList<>();
	private ArrayList<String> font = new ArrayList<>();
	private ArrayList<String> clears = new ArrayList<>();
	
	private LinearLayout alllin;
	private LinearLayout topbar;
	private LinearLayout root_layout;
	private ImageView imageview1;
	private TextView textview8;
	private LinearLayout linear65;
	private LinearLayout main_set;
	private LinearLayout seting_1;
	private LinearLayout setting_2;
	private LinearLayout linear69;
	private LinearLayout ui_lin;
	private LinearLayout linear68;
	private LinearLayout v_lin;
	private LinearLayout email_lin;
	private LinearLayout tele_lin;
	private LinearLayout pp_lin;
	private LinearLayout linear71;
	private TextView textview53;
	private Switch switch1;
	private TextView textview17;
	private ImageView imageview3;
	private TextView textview50;
	private ImageView imageview4;
	private TextView version_txt;
	private TextView versionsub_txt;
	private TextView textview41;
	private TextView textview42;
	private TextView textview32;
	private TextView textview33;
	private TextView textview49;
	private TextView textview54;
	private LinearLayout linear76;
	private LinearLayout linear75;
	private LinearLayout linear77;
	private LinearLayout linear78;
	private LinearLayout linear79;
	private TextView textview58;
	private TextView textview71;
	private ImageView imageview8;
	private TextView textview57;
	private TextView textview73;
	private ImageView imageview7;
	private TextView textview59;
	private Switch switch4;
	private TextView textview60;
	private Switch switch5;
	private TextView textview61;
	private Switch switch6;
	private LinearLayout linear82;
	private LinearLayout linear81;
	private LinearLayout linear83;
	private LinearLayout linear84;
	private LinearLayout linear86;
	private TextView textview63;
	private Switch switch8;
	private TextView textview62;
	private Switch switch7;
	private TextView textview64;
	private Switch switch9;
	private TextView textview65;
	private Switch switch10;
	private LinearLayout linear89;
	private LinearLayout linear90;
	private TextView textview69;
	private ImageView imageview11;
	private TextView textview70;
	private Switch switch11;
	
	private TimerTask timer;
	private SharedPreferences night;
	private SharedPreferences database;
	private Intent visit = new Intent();
	private SharedPreferences setting;
	private SharedPreferences home;
	private SharedPreferences save;
	private SharedPreferences Searcher;
	private AlertDialog.Builder Engine;
	private AlertDialog.Builder font_sizer;
	private AlertDialog.Builder clear_data;
	private SharedPreferences sr;
	private Intent i = new Intent();
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.setting);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		
		alllin = (LinearLayout) findViewById(R.id.alllin);
		topbar = (LinearLayout) findViewById(R.id.topbar);
		root_layout = (LinearLayout) findViewById(R.id.root_layout);
		imageview1 = (ImageView) findViewById(R.id.imageview1);
		textview8 = (TextView) findViewById(R.id.textview8);
		linear65 = (LinearLayout) findViewById(R.id.linear65);
		main_set = (LinearLayout) findViewById(R.id.main_set);
		seting_1 = (LinearLayout) findViewById(R.id.seting_1);
		setting_2 = (LinearLayout) findViewById(R.id.setting_2);
		linear69 = (LinearLayout) findViewById(R.id.linear69);
		ui_lin = (LinearLayout) findViewById(R.id.ui_lin);
		linear68 = (LinearLayout) findViewById(R.id.linear68);
		v_lin = (LinearLayout) findViewById(R.id.v_lin);
		email_lin = (LinearLayout) findViewById(R.id.email_lin);
		tele_lin = (LinearLayout) findViewById(R.id.tele_lin);
		pp_lin = (LinearLayout) findViewById(R.id.pp_lin);
		linear71 = (LinearLayout) findViewById(R.id.linear71);
		textview53 = (TextView) findViewById(R.id.textview53);
		switch1 = (Switch) findViewById(R.id.switch1);
		textview17 = (TextView) findViewById(R.id.textview17);
		imageview3 = (ImageView) findViewById(R.id.imageview3);
		textview50 = (TextView) findViewById(R.id.textview50);
		imageview4 = (ImageView) findViewById(R.id.imageview4);
		version_txt = (TextView) findViewById(R.id.version_txt);
		versionsub_txt = (TextView) findViewById(R.id.versionsub_txt);
		textview41 = (TextView) findViewById(R.id.textview41);
		textview42 = (TextView) findViewById(R.id.textview42);
		textview32 = (TextView) findViewById(R.id.textview32);
		textview33 = (TextView) findViewById(R.id.textview33);
		textview49 = (TextView) findViewById(R.id.textview49);
		textview54 = (TextView) findViewById(R.id.textview54);
		linear76 = (LinearLayout) findViewById(R.id.linear76);
		linear75 = (LinearLayout) findViewById(R.id.linear75);
		linear77 = (LinearLayout) findViewById(R.id.linear77);
		linear78 = (LinearLayout) findViewById(R.id.linear78);
		linear79 = (LinearLayout) findViewById(R.id.linear79);
		textview58 = (TextView) findViewById(R.id.textview58);
		textview71 = (TextView) findViewById(R.id.textview71);
		imageview8 = (ImageView) findViewById(R.id.imageview8);
		textview57 = (TextView) findViewById(R.id.textview57);
		textview73 = (TextView) findViewById(R.id.textview73);
		imageview7 = (ImageView) findViewById(R.id.imageview7);
		textview59 = (TextView) findViewById(R.id.textview59);
		switch4 = (Switch) findViewById(R.id.switch4);
		textview60 = (TextView) findViewById(R.id.textview60);
		switch5 = (Switch) findViewById(R.id.switch5);
		textview61 = (TextView) findViewById(R.id.textview61);
		switch6 = (Switch) findViewById(R.id.switch6);
		linear82 = (LinearLayout) findViewById(R.id.linear82);
		linear81 = (LinearLayout) findViewById(R.id.linear81);
		linear83 = (LinearLayout) findViewById(R.id.linear83);
		linear84 = (LinearLayout) findViewById(R.id.linear84);
		linear86 = (LinearLayout) findViewById(R.id.linear86);
		textview63 = (TextView) findViewById(R.id.textview63);
		switch8 = (Switch) findViewById(R.id.switch8);
		textview62 = (TextView) findViewById(R.id.textview62);
		switch7 = (Switch) findViewById(R.id.switch7);
		textview64 = (TextView) findViewById(R.id.textview64);
		switch9 = (Switch) findViewById(R.id.switch9);
		textview65 = (TextView) findViewById(R.id.textview65);
		switch10 = (Switch) findViewById(R.id.switch10);
		linear89 = (LinearLayout) findViewById(R.id.linear89);
		linear90 = (LinearLayout) findViewById(R.id.linear90);
		textview69 = (TextView) findViewById(R.id.textview69);
		imageview11 = (ImageView) findViewById(R.id.imageview11);
		textview70 = (TextView) findViewById(R.id.textview70);
		switch11 = (Switch) findViewById(R.id.switch11);
		night = getSharedPreferences("night", Activity.MODE_PRIVATE);
		database = getSharedPreferences("database", Activity.MODE_PRIVATE);
		setting = getSharedPreferences("setting", Activity.MODE_PRIVATE);
		home = getSharedPreferences("home", Activity.MODE_PRIVATE);
		save = getSharedPreferences("save", Activity.MODE_PRIVATE);
		Searcher = getSharedPreferences("Searcher", Activity.MODE_PRIVATE);
		Engine = new AlertDialog.Builder(this);
		font_sizer = new AlertDialog.Builder(this);
		clear_data = new AlertDialog.Builder(this);
		sr = getSharedPreferences("sr", Activity.MODE_PRIVATE);
		
		imageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				finish();
			}
		});
		
		linear69.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (switch1.isChecked()) {
					switch1.setChecked(false);
				}
				else {
					switch1.setChecked(true);
				}
			}
		});
		
		ui_lin.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				n1 = 1;
				main_set.setVisibility(View.GONE);
				seting_1.setVisibility(View.VISIBLE);
				setting_2.setVisibility(View.GONE);
			}
		});
		
		linear68.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				n2 = 1;
				main_set.setVisibility(View.GONE);
				setting_2.setVisibility(View.VISIBLE);
				seting_1.setVisibility(View.GONE);
			}
		});
		
		pp_lin.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), BrowseActivity.class);
				i.putExtra("intenturl", "https://litewebbrowser.blogspot.com/p/privacy-policy-body-font-family.html?m=1");
				startActivity(i);
			}
		});
		
		linear71.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				setting.edit().putString("savefromdata", "t").commit();
				setting.edit().putString("ck", "t").commit();
				setting.edit().putString("sv", "t").commit();
				setting.edit().putString("exit_data", "t").commit();
				setting.edit().putString("js_popup", "f").commit();
				setting.edit().putString("location", "f").commit();
				setting.edit().putString("js", "t").commit();
				Searcher.edit().putString("search", "Google").commit();
				setting.edit().putString("fontsizename", "Normal").commit();
				_CheckSettings();
				i.setClass(getApplicationContext(), MainActivity.class);
				startActivity(i);
				finish();
			}
		});
		
		switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2)  {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					//Asd for intent-filter
				}
				else {
					//Asd for intent-filter
				}
			}
		});
		
		linear76.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				Engine.setTitle("Default Search Engine");
				Engine.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						SketchwareUtil.showMessage(getApplicationContext(), item_);
						if (item_.equals("Google")) {
							Searcher.edit().putString("search", "Google").commit();
						}
						if (item_.equals("Naver")) {
							Searcher.edit().putString("search", "Naver").commit();
						}
						if (item_.equals("Duckduckgo")) {
							Searcher.edit().putString("search", "DuckDuckGo").commit();
						}
						if (item_.equals("Yahoo")) {
							Searcher.edit().putString("search", "Yahoo").commit();
						}
						textview71.setText(Searcher.getString("search", ""));
					}
				});
				_Single_Choice_Dialog(Engine, search_list);
				Engine.create().show();
			}
		});
		
		linear75.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				font_sizer.setTitle("Website Font Size");
				font_sizer.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						SketchwareUtil.showMessage(getApplicationContext(), item_);
						if (item_.equals("Smallest")) {
							setting.edit().putString("fontsizename", "Smallest").commit();
							setting.edit().putString("fontsize", "50").commit();
						}
						if (item_.equals("Smaller")) {
							setting.edit().putString("fontsizename", "Smaller").commit();
							setting.edit().putString("fontsize", "75").commit();
						}
						if (item_.equals("Normal")) {
							setting.edit().putString("fontsizename", "Normal").commit();
							setting.edit().putString("fontsize", "100").commit();
						}
						if (item_.equals("Larger")) {
							setting.edit().putString("fontsizename", "Larger").commit();
							setting.edit().putString("fontsize", "150").commit();
						}
						if (item_.equals("Largest")) {
							setting.edit().putString("fontsizename", "Largest").commit();
							setting.edit().putString("fontsize", "200").commit();
						}
						textview73.setText(setting.getString("fontsizename", ""));
					}
				});
				_Single_Choice_Dialog(font_sizer, font);
				font_sizer.create().show();
			}
		});
		
		linear77.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (switch4.isChecked()) {
					switch4.setChecked(false);
				}
				else {
					switch4.setChecked(true);
				}
			}
		});
		
		linear78.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (switch5.isChecked()) {
					switch5.setChecked(false);
				}
				else {
					switch5.setChecked(true);
				}
			}
		});
		
		linear79.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (switch6.isChecked()) {
					switch6.setChecked(false);
				}
				else {
					switch6.setChecked(true);
				}
			}
		});
		
		switch4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2)  {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					setting.edit().putString("location", "t").commit();
				}
				else {
					setting.edit().putString("location", "f").commit();
				}
			}
		});
		
		switch5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2)  {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					setting.edit().putString("js_popup", "t").commit();
				}
				else {
					setting.edit().putString("js_popup", "f").commit();
				}
			}
		});
		
		switch6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2)  {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					setting.edit().putString("js", "t").commit();
				}
				else {
					setting.edit().putString("js", "f").commit();
				}
			}
		});
		
		linear82.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (switch8.isChecked()) {
					switch8.setChecked(false);
				}
				else {
					switch8.setChecked(true);
				}
			}
		});
		
		linear81.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (switch7.isChecked()) {
					switch7.setChecked(false);
				}
				else {
					switch7.setChecked(true);
				}
			}
		});
		
		linear83.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (switch9.isChecked()) {
					switch9.setChecked(false);
				}
				else {
					switch9.setChecked(true);
				}
			}
		});
		
		linear84.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (switch10.isChecked()) {
					switch10.setChecked(false);
				}
				else {
					switch10.setChecked(true);
				}
			}
		});
		
		switch8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2)  {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					setting.edit().putString("saveformdata", "t").commit();
				}
				else {
					setting.edit().putString("saveformdata", "f").commit();
				}
			}
		});
		
		switch7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2)  {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					setting.edit().putString("ck", "t").commit();
				}
				else {
					setting.edit().putString("ck", "f").commit();
				}
			}
		});
		
		switch9.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2)  {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					setting.edit().putString("sv", "t").commit();
				}
				else {
					setting.edit().putString("sv", "f").commit();
				}
			}
		});
		
		switch10.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2)  {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					setting.edit().putString("savelink", "t").commit();
				}
				else {
					setting.edit().putString("savelink", "f").commit();
				}
			}
		});
		
		linear89.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				//MultipleChoiceDialog
				clear_data.setTitle("Select Engine");
				clear_data.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						if (clears.contains("Cookies")) {
							CookieManager.getInstance().removeAllCookies(null);
							CookieManager.getInstance().flush();
						}
						if (clears.contains("History")) {
							sr.edit().remove(String.valueOf((long)(keys))).commit();
						}
						if (clears.contains("Cached pages")) {
							
						}
						if (clears.contains("Passwords")) {
							//clear password code
						}
						clears.clear();
					}
				});
				_MultiChoiceDialog(clear_data, li);
				clear_data.create().show();
			}
		});
		
		linear90.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (switch11.isChecked()) {
					switch11.setChecked(false);
				}
				else {
					switch11.setChecked(true);
				}
			}
		});
		
		switch11.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2)  {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					setting.edit().putString("exit_data", "t").commit();
				}
				else {
					setting.edit().putString("exit_data", "f").commit();
				}
			}
		});
	}
	
	private void initializeLogic() {
		_Font();
		search_list.add("Google");
		search_list.add("Naver");
		search_list.add("Duckduckgo");
		search_list.add("Yahoo");
		li.add("History");
		li.add("Cached pages");
		li.add("Passwords");
		li.add("Cookies");
		font.add("Smallest");
		font.add("Smaller");
		font.add("Normal");
		font.add("Larger");
		font.add("Largest");
		textview71.setText(Searcher.getString("search", ""));
		textview73.setText(setting.getString("fontsizename", ""));
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
		_CheckSettings();
	}
	
	@Override
	public void onBackPressed() {
		if ((n1 == 1) || (n2 == 1)) {
			if (n1 == 1) {
				setting_2.setVisibility(View.GONE);
				seting_1.setVisibility(View.GONE);
				main_set.setVisibility(View.VISIBLE);
				n1 = 0;
			}
			else {
				if (n2 == 1) {
					setting_2.setVisibility(View.GONE);
					seting_1.setVisibility(View.GONE);
					main_set.setVisibility(View.VISIBLE);
					n2 = 0;
				}
				else {
					
				}
			}
		}
		else {
			finish();
		}
	}
	public void _Font () {
		textview8.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/roboto_regular.ttf"), 0);
		textview53.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/roboto_regular.ttf"), 0);
		textview17.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/roboto_regular.ttf"), 0);
		textview50.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/roboto_regular.ttf"), 0);
		versionsub_txt.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/roboto_regular.ttf"), 0);
		versionsub_txt.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/roboto_regular.ttf"), 0);
		textview42.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/roboto_regular.ttf"), 0);
		textview33.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/roboto_regular.ttf"), 0);
		textview54.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/roboto_regular.ttf"), 0);
		textview58.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/roboto_regular.ttf"), 0);
		textview71.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/roboto_regular.ttf"), 0);
		textview57.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/roboto_regular.ttf"), 0);
		textview73.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/roboto_regular.ttf"), 0);
		textview59.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/roboto_regular.ttf"), 0);
		textview60.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/roboto_regular.ttf"), 0);
		textview61.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/roboto_regular.ttf"), 0);
		textview63.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/roboto_regular.ttf"), 0);
		textview62.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/roboto_regular.ttf"), 0);
		textview64.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/roboto_regular.ttf"), 0);
		textview65.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/roboto_regular.ttf"), 0);
		textview69.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/roboto_regular.ttf"), 0);
		textview70.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/roboto_regular.ttf"), 0);
		textview41.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/roboto_medium.ttf"), 0);
		textview32.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/roboto_medium.ttf"), 0);
		textview49.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/roboto_medium.ttf"), 0);
		version_txt.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/roboto_medium.ttf"), 0);
	}
	
	
	public void _SetTextColor (final TextView _textview, final String _color) {
		_textview.setTextColor(Color.parseColor(_color));
	}
	
	
	public void _Single_Choice_Dialog (final AlertDialog.Builder _dialog, final ArrayList<String> _list) {
		final CharSequence[] _items = _list.toArray(new String[_list.size()]);
		_dialog.setSingleChoiceItems(_items, -1, new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				wh_ = which;
				item_ = _list.get((int)(wh_));
				
			}});
	}
	
	
	public void _MultiChoiceDialog (final AlertDialog.Builder _dialog, final ArrayList<String> _list) {
		final String[] _items = _list.toArray(new String[_list.size()]);
		_dialog.setMultiChoiceItems(_items, null, new DialogInterface.OnMultiChoiceClickListener()  {
			public void onClick(DialogInterface dialog, int which, boolean isChecked) {
				if (isChecked) {
					clears.add(_items[which]);
				}
				else {
					clears.remove(_items[which]);
				}
			}});
	}
	
	
	public void _CheckSettings () {
		if (setting.getString("location", "").equals("t")) {
			switch4.setChecked(true);
		}
		else {
			switch4.setChecked(false);
		}
		if (setting.getString("js_popup", "").equals("t")) {
			switch5.setChecked(true);
		}
		else {
			switch5.setChecked(false);
		}
		if (setting.getString("js", "").equals("t")) {
			switch6.setChecked(true);
		}
		else {
			switch6.setChecked(false);
		}
		if (setting.getString("ck", "").equals("t")) {
			switch7.setChecked(true);
		}
		else {
			switch7.setChecked(false);
		}
		if (setting.getString("saveformdata", "").equals("t")) {
			switch8.setChecked(true);
		}
		else {
			switch8.setChecked(false);
		}
		if (setting.getString("sv", "").equals("t")) {
			switch9.setChecked(true);
		}
		else {
			switch9.setChecked(false);
		}
		if (setting.getString("savelink", "").equals("t")) {
			switch10.setChecked(true);
		}
		else {
			switch10.setChecked(false);
		}
		if (setting.getString("exit_data", "").equals("t")) {
			switch11.setChecked(true);
		}
		else {
			switch11.setChecked(false);
		}
		textview71.setText(Searcher.getString("search", ""));
		textview73.setText(setting.getString("fontsizename", ""));
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