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
import java.util.HashMap;
import java.util.ArrayList;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.webkit.WebView;
import android.webkit.WebSettings;
import android.widget.Button;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.Intent;
import android.net.Uri;
import android.app.AlertDialog;
import android.content.DialogInterface;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.TimerTask;
import android.view.View;
import android.webkit.WebViewClient;
import android.text.Editable;
import android.text.TextWatcher;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.startapp.sdk.*;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;
import androidx.core.content.ContextCompat;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.content.pm.PackageManager;
import com.startapp.sdk.adsbase.adlisteners.*;
import com.startapp.sdk.adsbase.*;
import com.startapp.sdk.ads.banner.*;

public class BrowseActivity extends  AppCompatActivity  { 
	
	private Timer _timer = new Timer();
	
	private boolean isTyping = false;
	private boolean isRunning = false;
	private String webtitle = "";
	private HashMap<String, Object> mp = new HashMap<>();
	private HashMap<String, Object> map = new HashMap<>();
	private double key = 0;
	private double keys = 0;
	private String filename = "";
	private String app_path = "";
	private String result = "";
	private double fontSize = 0;
	private boolean desk = false;
	private String screenshot_dir = "";
	private String off_dir = "";
	private String share_tent = "";
	private String screenshot_path = "";
	private double n = 0;
	private String off_file_path = "";
	private boolean connected = false;
	private String ID_Placement_banner = "";
	private  final String TAG = BrowseActivity.class.getSimpleName();;
	private double banner_fail = 0;
	private String ErrorLoadFBBannerAd = "";
	private double banner_complete = 0;
	
	private ArrayList<HashMap<String, Object>> list_map = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> hist_map = new ArrayList<>();
	private ArrayList<String> offline_list = new ArrayList<>();
	
	private LinearLayout rootbrowse;
	private LinearLayout banner_container;
	private LinearLayout url_bar;
	private LinearLayout webprogress;
	private LinearLayout indicator;
	private LinearLayout indicator2;
	private LinearLayout browse_container;
	private LinearLayout indicator3;
	private LinearLayout bottom_container;
	private LinearLayout url_layout;
	private TextView searchbytext;
	private ImageView imageview1;
	private TextView title;
	private EditText search;
	private ImageView clear;
	private ImageView stop;
	private ImageView refresh;
	private ProgressBar progressbar;
	private LinearLayout webview_linear;
	private LinearLayout connection_linear;
	private WebView webbrowser;
	private TextView no_internet;
	private Button try_refresh;
	private ImageView back;
	private ImageView forward;
	private ImageView menu;
	private ImageView tab;
	private ImageView home;
	
	private SharedPreferences setting;
	private SharedPreferences save;
	private SharedPreferences night;
	private Intent i = new Intent();
	private AlertDialog.Builder dialog;
	private SharedPreferences database;
	private RequestNetwork req;
	private RequestNetwork.RequestListener _req_request_listener;
	private SharedPreferences Searcher;
	private Calendar cal = Calendar.getInstance();
	private SharedPreferences sp;
	private SharedPreferences sr;
	private SharedPreferences application_path;
	private Calendar c = Calendar.getInstance();
	private TimerTask t;
	private AlertDialog.Builder resubmit;
	private TimerTask ad;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.browse);
		initialize(_savedInstanceState);
		if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED
		|| ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
			ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1000);
		}
		else {
			initializeLogic();
		}
	}
	@Override
	public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		if (requestCode == 1000) {
			initializeLogic();
		}
	}
	
	private void initialize(Bundle _savedInstanceState) {
		
		rootbrowse = (LinearLayout) findViewById(R.id.rootbrowse);
		banner_container = (LinearLayout) findViewById(R.id.banner_container);
		url_bar = (LinearLayout) findViewById(R.id.url_bar);
		webprogress = (LinearLayout) findViewById(R.id.webprogress);
		indicator = (LinearLayout) findViewById(R.id.indicator);
		indicator2 = (LinearLayout) findViewById(R.id.indicator2);
		browse_container = (LinearLayout) findViewById(R.id.browse_container);
		indicator3 = (LinearLayout) findViewById(R.id.indicator3);
		bottom_container = (LinearLayout) findViewById(R.id.bottom_container);
		url_layout = (LinearLayout) findViewById(R.id.url_layout);
		searchbytext = (TextView) findViewById(R.id.searchbytext);
		imageview1 = (ImageView) findViewById(R.id.imageview1);
		title = (TextView) findViewById(R.id.title);
		search = (EditText) findViewById(R.id.search);
		clear = (ImageView) findViewById(R.id.clear);
		stop = (ImageView) findViewById(R.id.stop);
		refresh = (ImageView) findViewById(R.id.refresh);
		progressbar = (ProgressBar) findViewById(R.id.progressbar);
		webview_linear = (LinearLayout) findViewById(R.id.webview_linear);
		connection_linear = (LinearLayout) findViewById(R.id.connection_linear);
		webbrowser = (WebView) findViewById(R.id.webbrowser);
		webbrowser.getSettings().setJavaScriptEnabled(true);
		webbrowser.getSettings().setSupportZoom(true);
		no_internet = (TextView) findViewById(R.id.no_internet);
		try_refresh = (Button) findViewById(R.id.try_refresh);
		back = (ImageView) findViewById(R.id.back);
		forward = (ImageView) findViewById(R.id.forward);
		menu = (ImageView) findViewById(R.id.menu);
		tab = (ImageView) findViewById(R.id.tab);
		home = (ImageView) findViewById(R.id.home);
		setting = getSharedPreferences("setting", Activity.MODE_PRIVATE);
		save = getSharedPreferences("save", Activity.MODE_PRIVATE);
		night = getSharedPreferences("night", Activity.MODE_PRIVATE);
		dialog = new AlertDialog.Builder(this);
		database = getSharedPreferences("database", Activity.MODE_PRIVATE);
		req = new RequestNetwork(this);
		Searcher = getSharedPreferences("Searcher", Activity.MODE_PRIVATE);
		sp = getSharedPreferences("sp", Activity.MODE_PRIVATE);
		sr = getSharedPreferences("sr", Activity.MODE_PRIVATE);
		application_path = getSharedPreferences("application_path", Activity.MODE_PRIVATE);
		resubmit = new AlertDialog.Builder(this);
		
		searchbytext.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (searchbytext.getText().toString().equals("Cancel")) {
					if (webtitle.equals("")) {
						title.setText(webbrowser.getUrl());
					}
					else {
						title.setText(webtitle);
					}
					if (isRunning) {
						refresh.setVisibility(View.GONE);
						stop.setVisibility(View.VISIBLE);
					}
					else {
						refresh.setVisibility(View.VISIBLE);
						stop.setVisibility(View.GONE);
					}
					title.setVisibility(View.VISIBLE);
					clear.setVisibility(View.GONE);
					search.setVisibility(View.GONE);
					searchbytext.setVisibility(View.GONE);
					isTyping = false;
				}
				else {
					if (search.getText().toString().contains("http://") || search.getText().toString().contains("https://")) {
						webbrowser.loadUrl(search.getText().toString());
					}
					else {
						if (search.getText().toString().contains(".")) {
							webbrowser.loadUrl("http://".concat(search.getText().toString()));
						}
						else {
							if (Searcher.getString("search", "").equals("Google")) {
								webbrowser.loadUrl("https://www.google.com/search?q=".concat(search.getText().toString()));
							}
							if (Searcher.getString("search", "").equals("Naver")) {
								webbrowser.loadUrl("https://search.naver.com/search.naver?&query=".concat(search.getText().toString()));
							}
							if (Searcher.getString("search", "").equals("DuckDuckGo")) {
								webbrowser.loadUrl("https://duckduckgo.com/?q=".concat(search.getText().toString()));
							}
							if (Searcher.getString("search", "").equals("Yahoo")) {
								webbrowser.loadUrl("https://search.yahoo.com/search?p=".concat(search.getText().toString()));
							}
							if (Searcher.getString("search", "").equals("")) {
								webbrowser.loadUrl("https://www.google.com/search?q=".concat(search.getText().toString()));
							}
						}
					}
					searchbytext.setVisibility(View.GONE);
					search.setVisibility(View.GONE);
					title.setVisibility(View.VISIBLE);
					refresh.setVisibility(View.VISIBLE);
					clear.setVisibility(View.GONE);
				}
			}
		});
		
		title.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				isTyping = true;
				search.setVisibility(View.VISIBLE);
				searchbytext.setVisibility(View.VISIBLE);
				title.setVisibility(View.GONE);
				stop.setVisibility(View.GONE);
				refresh.setVisibility(View.GONE);
				search.setText(webbrowser.getUrl());
				search.setSelectAllOnFocus(true);
				if (search.getText().toString().length() > 0) {
					clear.setVisibility(View.VISIBLE);
					searchbytext.setText("Search");
				}
				else {
					searchbytext.setText("Cancel");
					clear.setVisibility(View.GONE);
				}
			}
		});
		
		search.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				if (_charSeq.length() > 0) {
					if (isTyping) {
						clear.setVisibility(View.VISIBLE);
						searchbytext.setText("Search");
					}
				}
				else {
					searchbytext.setText("Cancel");
					clear.setVisibility(View.GONE);
				}
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		clear.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				search.setText("");
			}
		});
		
		stop.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				webbrowser.stopLoading();
				webprogress.setVisibility(View.GONE);
				refresh.setVisibility(View.VISIBLE);
			}
		});
		
		refresh.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (isRunning) {
					webbrowser.stopLoading();
					stop.setVisibility(View.GONE);
					clear.setVisibility(View.GONE);
					searchbytext.setVisibility(View.GONE);
					webbrowser.reload();
				}
				else {
					webbrowser.reload();
				}
			}
		});
		
		webbrowser.setWebViewClient(new WebViewClient() {
			@Override
			public void onPageStarted(WebView _param1, String _param2, Bitmap _param3) {
				final String _url = _param2;
				isRunning = true;
				webtitle = webbrowser.getTitle();
				if (webtitle.equals("")) {
					title.setText(_url);
				}
				else {
					title.setText(webtitle);
				}
				if (!webbrowser.canGoBack()) {
					back.setImageResource(R.drawable.blocked_backward);
				}
				else {
					back.setImageResource(R.drawable.back);
				}
				if (!webbrowser.canGoForward()) {
					forward.setImageResource(R.drawable.blocked_forward);
				}
				else {
					forward.setImageResource(R.drawable.dback);
				}
				title.setVisibility(View.VISIBLE);
				stop.setVisibility(View.VISIBLE);
				webprogress.setVisibility(View.VISIBLE);
				search.setVisibility(View.GONE);
				clear.setVisibility(View.GONE);
				refresh.setVisibility(View.GONE);
				searchbytext.setVisibility(View.GONE);
				save.edit().putString("save", _url).commit();
				req.startRequestNetwork(RequestNetworkController.GET, "https://www.google.com", "A", _req_request_listener);
				mp = new HashMap<>();
				mp.put("title", title.getText().toString());
				mp.put("url", _url);
				cal = Calendar.getInstance();
				mp.put("time", new SimpleDateFormat("dd MMMM  yyyy - hh:mm a").format(cal.getTime()));
				hist_map.add((int)0, mp);
				sr.edit().putString(String.valueOf((long)(keys)), new Gson().toJson(hist_map)).commit();
				super.onPageStarted(_param1, _param2, _param3);
			}
			
			@Override
			public void onPageFinished(WebView _param1, String _param2) {
				final String _url = _param2;
				webtitle = webbrowser.getTitle();
				if (webtitle.equals("")) {
					title.setText(_url);
				}
				else {
					title.setText(webtitle);
				}
				refresh.setVisibility(View.VISIBLE);
				title.setVisibility(View.VISIBLE);
				search.setVisibility(View.GONE);
				clear.setVisibility(View.GONE);
				stop.setVisibility(View.GONE);
				webprogress.setVisibility(View.GONE);
				isRunning = false;
				save.edit().putString("save", _url).commit();
				super.onPageFinished(_param1, _param2);
			}
		});
		
		try_refresh.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				webbrowser.loadUrl(webbrowser.getUrl());
			}
		});
		
		back.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (isRunning) {
					webbrowser.stopLoading();
					if (webbrowser.canGoBack()) {
						webbrowser.goBack();
					}
				}
				else {
					if (webbrowser.canGoBack()) {
						webbrowser.goBack();
					}
				}
			}
		});
		
		forward.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (isRunning) {
					webbrowser.stopLoading();
					if (webbrowser.canGoForward()) {
						webbrowser.goForward();
					}
				}
				else {
					if (webbrowser.canGoForward()) {
						webbrowser.goForward();
					}
				}
			}
		});
		
		menu.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				final com.google.android.material.bottomsheet.BottomSheetDialog bottomSheetDialog = new com.google.android.material.bottomsheet.BottomSheetDialog(BrowseActivity.this);
				
				View bottomSheetView; bottomSheetView = getLayoutInflater().inflate(R.layout.bottom_sheet_p3,null );
				bottomSheetDialog.setContentView(bottomSheetView);
				
				bottomSheetDialog.getWindow().findViewById(R.id.design_bottom_sheet).setBackgroundResource(android.R.color.transparent);
				LinearLayout bg = (LinearLayout) bottomSheetView.findViewById(R.id.bg);
				
				ImageView close = (ImageView) bottomSheetView.findViewById(R.id.imageview37);
				
				ImageView open_settings = (ImageView) bottomSheetView.findViewById(R.id.imageview38);
				
				ImageView exit = (ImageView) bottomSheetView.findViewById(R.id.imageview36);
				
				ImageView add_book = (ImageView) bottomSheetView.findViewById(R.id.imageview30);
				
				ImageView view_books = (ImageView) bottomSheetView.findViewById(R.id.imageview17);
				
				final ImageView desktop = (ImageView) bottomSheetView.findViewById(R.id.imageview23);
				
				ImageView take_screen = (ImageView) bottomSheetView.findViewById(R.id.imageview29);
				
				ImageView downloads_file = (ImageView) bottomSheetView.findViewById(R.id.imageview19);
				
				ImageView offline_page = (ImageView) bottomSheetView.findViewById(R.id.imageview33);
				
				ImageView incognito_img = (ImageView) bottomSheetView.findViewById(R.id.imageview31);
				
				ImageView block_image  = (ImageView) bottomSheetView.findViewById(R.id.imageview20);
				
				ImageView share_in  = (ImageView) bottomSheetView.findViewById(R.id.imageview34);
				
				ImageView refresher  = (ImageView) bottomSheetView.findViewById(R.id.imageview32);
				_rippleRoundStroke(bg, "#FFFFFF", "#000000", 15, 0, "#000000");
				if (desk) {
					desktop.setImageResource(R.drawable.desktop_on);
				}
				else {
					desktop.setImageResource(R.drawable.desktop_mode);
				}
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
							webbrowser.getSettings().setBlockNetworkImage(false);
						}
						else {
							setting.edit().putString("block_img", "t").commit();
							webbrowser.getSettings().setBlockNetworkImage(true);
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
				desktop.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){
						bottomSheetDialog.dismiss();
						if (desk) {
							desktop.setImageResource(R.drawable.desktop_mode);
							desk = false;
						}
						else {
							desktop.setImageResource(R.drawable.desktop_on);
							desk = true;
							
							webbrowser.getSettings().setLoadWithOverviewMode(true); webbrowser.getSettings().setUseWideViewPort(true); final WebSettings webSettings = webbrowser.getSettings(); final String newUserAgent; newUserAgent = "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2228.0 Safari/537.36"; webSettings.setUserAgentString(newUserAgent);
							_refresher_web();
						}
					}});
				close.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){
						bottomSheetDialog.dismiss();
					}});
				refresher.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){
						bottomSheetDialog.dismiss();
						_refresher_web();
					}});
				share_in.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){
						bottomSheetDialog.dismiss();
						share_tent = save.getString("save", "");
						Intent i = new Intent(android.content.Intent.ACTION_SEND); i.setType("text/plain");  i.putExtra(android.content.Intent.EXTRA_TEXT, share_tent); startActivity(Intent.createChooser(i,"Share using"));
					}});
				offline_page.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){
						bottomSheetDialog.dismiss();
						off_file_path = off_dir.concat("/").concat(title.getText().toString().concat(String.valueOf((long)(n))).concat(".mht"));
						t = new TimerTask() {
							@Override
							public void run() {
								runOnUiThread(new Runnable() {
									@Override
									public void run() {
										if (FileUtil.isExistFile(off_dir.concat(title.getText().toString().concat(String.valueOf((long)(n))).concat(".mht")))) {
											n++;
											webbrowser.saveWebArchive(off_file_path);
										}
										else {
											t.cancel();
											off_file_path = off_dir.concat("/").concat(title.getText().toString().concat(String.valueOf((long)(n))).concat(".mht"));
											webbrowser.saveWebArchive(off_file_path);
										}
									}
								});
							}
						};
						_timer.scheduleAtFixedRate(t, (int)(200), (int)(100));
						SketchwareUtil.showMessage(getApplicationContext(), "Webpage Saved");
					}});
				downloads_file.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){
						bottomSheetDialog.dismiss();
						startActivity(new Intent(DownloadManager.ACTION_VIEW_DOWNLOADS));
					}});
				exit.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){
						bottomSheetDialog.dismiss();
						_finish();
					}});
				open_settings.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){
						bottomSheetDialog.dismiss();
						i.setClass(getApplicationContext(), SettingActivity.class);
						startActivity(i);
					}});
				take_screen.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){
						bottomSheetDialog.dismiss();
						c = Calendar.getInstance();
						screenshot_path = screenshot_dir.concat("/".concat(new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss").format(c.getTime()).concat(".jpg")));
						storeImage(getBitmapFromView(webbrowser));
						SketchwareUtil.showMessage(getApplicationContext(), "Screenshot Saved");
						storeImage(getBitmapFromView(webbrowser));
						SketchwareUtil.showMessage(getApplicationContext(), "Screenshot Saved");
					}});
				add_book.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){
						bottomSheetDialog.dismiss();
						//Add to bookmarks Block
						map = new HashMap<>();
						map.put("title", title.getText().toString());
						map.put("url", webbrowser.getUrl());
						cal = Calendar.getInstance();
						map.put("time", new SimpleDateFormat("dd MMMM  yyyy - hh:mm a").format(cal.getTime()));
						list_map.add((int)0, map);
						sp.edit().putString(String.valueOf((long)(key)), new Gson().toJson(list_map)).commit();
						SketchwareUtil.showMessage(getApplicationContext(), "Bookmarked");
					}});
				view_books.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){
						bottomSheetDialog.dismiss();
						i.setClass(getApplicationContext(), BookmarkhistoryActivity.class);
						startActivity(i);
					}});
				bottomSheetDialog.setCancelable(true);
				bottomSheetDialog.show();
			}
		});
		
		tab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (isRunning) {
					webbrowser.stopLoading();
					stop.setVisibility(View.GONE);
					clear.setVisibility(View.GONE);
					searchbytext.setVisibility(View.GONE);
					webbrowser.reload();
				}
				else {
					webbrowser.reload();
				}
			}
		});
		
		home.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				finish();
			}
		});
		
		_req_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				connection_linear.setVisibility(View.GONE);
				connected = true;
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				webview_linear.setVisibility(View.GONE);
				connection_linear.setVisibility(View.VISIBLE);
				connected = false;
			}
		};
	}
	
	private void initializeLogic() {
		if (FileUtil.isExistFile(FileUtil.getExternalStorageDir().concat("/Super Browser"))) {
			
		}
		else {
			FileUtil.makeDir(FileUtil.getExternalStorageDir().concat("/Super Browser"));
		}
		if (FileUtil.isExistFile(FileUtil.getExternalStorageDir().concat("/Super Browser/Offline"))) {
			
		}
		else {
			FileUtil.makeDir(FileUtil.getExternalStorageDir().concat("/Super Browser/Offline"));
		}
		if (FileUtil.isExistFile(FileUtil.getExternalStorageDir().concat("/Super Browser/Screenshot"))) {
			
		}
		else {
			FileUtil.makeDir(FileUtil.getExternalStorageDir().concat("/Super Browser/Screenshot"));
		}
		app_path = FileUtil.getExternalStorageDir().concat("/Super Browser");
		screenshot_dir = FileUtil.getExternalStorageDir().concat("/Super Browser/Screenshot");
		off_dir = FileUtil.getExternalStorageDir().concat("/Super Browser/Offline");
		webbrowser.setWebChromeClient(new WebChromeClient() { public void onProgressChanged(WebView view, int progress) { progressbar.setProgress(progress); } });
		_Superweb();
		webbrowser.setDownloadListener(new DownloadListener() {
			public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype, long contentLength) {
				DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
				String cookies = CookieManager.getInstance().getCookie(url);
				request.addRequestHeader("cookie", cookies);
				request.addRequestHeader("User-Agent", userAgent);
				request.setDescription("Downloading file...");
				request.setTitle(URLUtil.guessFileName(url, contentDisposition, mimetype));
				request.allowScanningByMediaScanner(); request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED); request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, URLUtil.guessFileName(url, contentDisposition, mimetype));
				
				DownloadManager manager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
				manager.enqueue(request);
				showMessage("Downloading File....");
				//Notif if success
				BroadcastReceiver onComplete = new BroadcastReceiver() {
					public void onReceive(Context ctxt, Intent intent) {
						showMessage("Download Complete!");
						unregisterReceiver(this);
					}};
				registerReceiver(onComplete, new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));
			}
		});
		webbrowser.getSettings().setBuiltInZoomControls(true);
		webbrowser.getSettings().setDisplayZoomControls(false);
		registerForContextMenu(webbrowser);
		_RoundAndBorder(try_refresh, "#FFFFFF", 1, "#FF596067", 10);
		android.graphics.drawable.GradientDrawable mc = new android.graphics.drawable.GradientDrawable();
		mc.setColor(Color.parseColor("#FFF1F3F4"));
		mc.setCornerRadius(40);
		url_layout.setBackground(mc);
		clear.setVisibility(View.GONE);
		searchbytext.setVisibility(View.GONE);
		search.setVisibility(View.GONE);
		connection_linear.setVisibility(View.GONE);
		webbrowser.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
		title.setText(getIntent().getStringExtra("intenturl"));
		webbrowser.loadUrl(getIntent().getStringExtra("intenturl"));
		save.edit().putString("save", webbrowser.getUrl()).commit();
		ad = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						
						
						
					}
				});
			}
		};
		_timer.scheduleAtFixedRate(ad, (int)(100), (int)(60000));
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
		if (isTyping) {
			search.setVisibility(View.GONE);
			title.setVisibility(View.VISIBLE);
			searchbytext.setVisibility(View.GONE);
			refresh.setVisibility(View.VISIBLE);
			clear.setVisibility(View.GONE);
			isTyping = false;
		}
		else {
			if (isRunning) {
				webbrowser.stopLoading();
				if (webbrowser.canGoBack()) {
					webbrowser.goBack();
				}
				else {
					if (setting.getString("exit_data", "").equals("t")) {
						webbrowser.clearHistory();
						webbrowser.clearFormData();
						sr.edit().remove(String.valueOf((long)(keys))).commit();
					}
					finish();
				}
			}
			else {
				if (webbrowser.canGoBack()) {
					webbrowser.goBack();
				}
				else {
					if (setting.getString("exit_data", "").equals("t")) {
						webbrowser.clearHistory();
						webbrowser.clearFormData();
						sr.edit().remove(String.valueOf((long)(keys))).commit();
					}
					finish();
				}
			}
		}
	}
	
	@Override
	public void onResume() {
		super.onResume();
		_getSettings();
		_Superweb();
		if (!sp.getString(String.valueOf((long)(key)), "").equals("")) {
			list_map = new Gson().fromJson(sp.getString(String.valueOf((long)(key)), ""), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
		}
		if (!sr.getString(String.valueOf((long)(keys)), "").equals("")) {
			hist_map = new Gson().fromJson(sr.getString(String.valueOf((long)(keys)), ""), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
		}
		if (!setting.getString("fontsize", "").equals("")) {
			fontSize = Double.parseDouble(setting.getString("fontsize", ""));
			webbrowser.getSettings().setTextZoom((int)fontSize);
		}
		else {
			webbrowser.getSettings().setTextZoom(100);
		}
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		if (setting.getString("exit_data", "").equals("t")) {
			webbrowser.clearHistory();
			webbrowser.clearFormData();
			sr.edit().remove(String.valueOf((long)(keys))).commit();
		}
	}
	
	public void _nightmode () {
		night.edit().putString("nm", "on").commit();
	}
	
	
	public void _RoundAndBorder (final View _view, final String _color1, final double _border, final String _color2, final double _round) {
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
		gd.setColor(Color.parseColor(_color1));
		gd.setCornerRadius((int) _round);
		gd.setStroke((int) _border, Color.parseColor(_color2));
		_view.setBackground(gd);
	}
	
	
	public void _onCreateContextMenu () {
	}
	// for Use addSourceDirectly
	// onCreate with value
	// "registerForContextMenu(webview1);
	 @Override
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
	{
		
		// Change webview1 with WebView id
		
		final WebView.HitTestResult result = webbrowser.getHitTestResult();
		
		MenuItem.OnMenuItemClickListener handler = new MenuItem.OnMenuItemClickListener() {
			public boolean onMenuItemClick(MenuItem item) {
				
				// This section is to Execute your
				// Popup Item
				
				switch (item.getItemId()){
					case 0:
					
					String DownloadImageURL = result.getExtra();
					
											if(URLUtil.isValidUrl(DownloadImageURL)){
						
													DownloadManager.Request request = new DownloadManager.Request(Uri.parse(DownloadImageURL));
													request.allowScanningByMediaScanner();
													request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
						
						DownloadManager downloadManager = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
						
						downloadManager.enqueue(request);
						
						showMessage("Image Has Been Saved");
						
					} else {
						
						showMessage("Sorry, Something Wrong...");
					}
					return true;
					
					case 1:
					webbrowser.loadUrl(result.getExtra());
					return true;
					
					case 2:
					setClipboard(getApplicationContext(), result.getExtra());
					
					showMessage("Link Has Been Copied");
					return true;
					
					case 3:
					
					Intent i = new Intent(Intent.ACTION_VIEW);
											i.setData(Uri.parse(result.getExtra()));
					startActivity(i);
					return true;
				}
				return true;
			}
		};
		
		if (result.getType() == WebView.HitTestResult.IMAGE_TYPE || result.getType() == WebView.HitTestResult.SRC_IMAGE_ANCHOR_TYPE) {
			
			
			// Menu options for an image.
			//set the header title to the image url
						menu.setHeaderTitle(result.getExtra());
			menu.add(0, 0, 0, "Save Image").setOnMenuItemClickListener(handler);
			menu.add(1, 1, 1, "View Image").setOnMenuItemClickListener(handler);
			menu.add(2, 2, 2, "Copy Image Link").setOnMenuItemClickListener(handler);
		} else if (result.getType() == WebView.HitTestResult.ANCHOR_TYPE || result.getType() == WebView.HitTestResult.SRC_ANCHOR_TYPE) {
			
			// Menu options for a hyperlink.
			//set the header title to the link url
						menu.setHeaderTitle(result.getExtra());
			menu.add(3, 3, 3, "Open In External").setOnMenuItemClickListener(handler);
			menu.add(2, 2, 2, "Copy Link").setOnMenuItemClickListener(handler);
		}
		
		super.onCreateContextMenu(menu, v, menuInfo);
	}
	// Extra Copied String to clipboard in bellow
	private void setClipboard(Context context, String text) {
		if(Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB) {
			
			android.text.ClipboardManager clipboard = (android.text.ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
			clipboard.setText(text);
		} else {
			
			android.content.ClipboardManager clipboard = (android.content.ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
			
			android.content.ClipData clip = ClipData.newPlainText("Copied Text", text);
						clipboard.setPrimaryClip(clip);
				}
	}
	
	
	public void _getSettings () {
		if (!sp.getString(String.valueOf((long)(key)), "").equals("")) {
			list_map = new Gson().fromJson(sp.getString(String.valueOf((long)(key)), ""), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
		}
		if (!sr.getString(String.valueOf((long)(keys)), "").equals("")) {
			hist_map = new Gson().fromJson(sr.getString(String.valueOf((long)(keys)), ""), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
		}
		if (setting.getString("js", "").equals("t")) {
			setting.edit().putString("js", "t").commit();
			webbrowser.getSettings().setJavaScriptEnabled(true);
		}
		else {
			if (setting.getString("js", "").equals("f")) {
				setting.edit().putString("js", "f").commit();
				webbrowser.getSettings().setJavaScriptEnabled(false);
			}
		}
		if (setting.getString("ck", "").equals("t")) {
			setting.edit().putString("ck", "t").commit();
			CookieManager.getInstance().setAcceptCookie(true);
		}
		else {
			if (setting.getString("ck", "").equals("f")) {
				setting.edit().putString("ck", "f").commit();
				CookieManager.getInstance().setAcceptCookie(false);
			}
		}
		if (setting.getString("sv", "").equals("t")) {
			setting.edit().putString("sv", "t").commit();
			webbrowser.getSettings().setSavePassword(true);
		}
		else {
			if (setting.getString("sv", "").equals("f")) {
				setting.edit().putString("sv", "f").commit();
				webbrowser.getSettings().setSavePassword(false);
			}
		}
		if (setting.getString("savelink", "").equals("t")) {
			setting.edit().putString("savelink", "t").commit();
		}
		else {
			if (setting.getString("savelink", "").equals("f")) {
				setting.edit().putString("savelink", "f").commit();
			}
		}
		if (setting.getString("js_popup", "").equals("t")) {
			setting.edit().putString("js_popup", "t").commit();
			webbrowser.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
		}
		else {
			if (setting.getString("js_popup", "").equals("f")) {
				setting.edit().putString("js_popup", "f").commit();
				webbrowser.getSettings().setJavaScriptCanOpenWindowsAutomatically(false);
			}
		}
		if (setting.getString("location", "").equals("t")) {
			setting.edit().putString("location", "t").commit();
			webbrowser.getSettings().setGeolocationEnabled(true);
		}
		else {
			if (setting.getString("location", "").equals("f")) {
				setting.edit().putString("location", "f").commit();
				webbrowser.getSettings().setGeolocationEnabled(false);
			}
		}
		if (setting.getString("saveformdata", "").equals("t")) {
			setting.edit().putString("saveformdata", "t").commit();
			webbrowser.getSettings().setSaveFormData(true);
		}
		else {
			if (setting.getString("saveformdata", "").equals("f")) {
				setting.edit().putString("saveformdata", "f").commit();
				webbrowser.getSettings().setSaveFormData(false);
			}
		}
		if (!setting.getString("fontsize", "").equals("")) {
			fontSize = Double.parseDouble(setting.getString("fontsize", ""));
			webbrowser.getSettings().setTextZoom((int)fontSize);
		}
		else {
			webbrowser.getSettings().setTextZoom(100);
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
	
	
	public void _extra () {
		
		
		//onCreate
	}
	private void storeImage(Bitmap image) { java.io.File pictureFile = new java.io.File(screenshot_path);
		if (pictureFile == null) { Log.d("MainActivity", "Error creating media file, check storage permissions: ");
			return; } try {
			java.io.FileOutputStream fos = new java.io.FileOutputStream(pictureFile); image.compress(Bitmap.CompressFormat.PNG, 90, fos);
			fos.close(); } catch (java.io.FileNotFoundException e) { Log.d("MainActivity", "File not found: " + e.getMessage()); } catch (java.io.IOException e) { Log.d("MainActivity", "Error accessing file: " + e.getMessage());
		}
	}
	
	private Bitmap getBitmapFromView(View view) { Bitmap returnedBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(),Bitmap.Config.ARGB_8888);
		Canvas canvas = new Canvas(returnedBitmap);
		android.graphics.drawable.Drawable bgDrawable =view.getBackground();
		if (bgDrawable!=null) { bgDrawable.draw(canvas); } else{ canvas.drawColor(Color.WHITE); }
		view.draw(canvas);
		return returnedBitmap;
		
		
		//button onClick
		
		
	}
	
	
	public void _finish () {
		finish();
	}
	
	
	public void _refresher_web () {
		if (isRunning) {
			webbrowser.stopLoading();
			stop.setVisibility(View.GONE);
			clear.setVisibility(View.GONE);
			searchbytext.setVisibility(View.GONE);
			webbrowser.reload();
		}
		else {
			webbrowser.reload();
		}
	}
	
	
	public void _Superweb () {
		webbrowser.getSettings().setAppCacheMaxSize(5*1024*1024); 
		webbrowser.getSettings().setAppCachePath(getApplicationContext().getCacheDir().getAbsolutePath()); 
		webbrowser.getSettings().setAllowFileAccess(true);
		webbrowser.getSettings().setAllowFileAccessFromFileURLs(true);
		webbrowser.getSettings().setAppCacheEnabled(true);
		webbrowser.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
		webbrowser.getSettings().setDomStorageEnabled(true);
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