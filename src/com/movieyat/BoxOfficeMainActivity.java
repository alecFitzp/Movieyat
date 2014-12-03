package com.movieyat;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Locale;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.movieyat.cache.ImageLoader;
import com.movieyat.data.Movie;
import com.movieyat.data.Root;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentPagerAdapter;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;


public class BoxOfficeMainActivity extends ActionBarActivity implements ActionBar.TabListener {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    ViewPager mViewPager;
    public static List<Movie> movies;
    public static Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_box_office_main);
        
        try {
			URL url = new URL("http://api.rottentomatoes.com/api/public/v1.0/lists/movies/box_office.json?apikey=7k9sqp32a3jn6gnj6zua7quz");
			
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			movies = mapper.readValue(url, Root.class).getMovies();
			
			Log.i("error", movies.get(0).getTitle());
		} catch (MalformedURLException e) {
			
		} catch (JsonParseException e) {
			
		} catch (JsonMappingException e) {
			
		} catch (IOException e) {
			
		}
        mContext = this.getApplicationContext();
        // Set up the action bar.
        final ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        // When swiping between different sections, select the corresponding
        // tab. We can also use ActionBar.Tab#select() to do this if we have
        // a reference to the Tab.
        mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                actionBar.setSelectedNavigationItem(position);
            }
        });

        // For each of the sections in the app, add a tab to the action bar.
        for (int i = 0; i < mSectionsPagerAdapter.getCount(); i++) {
            // Create a tab with text corresponding to the page title defined by
            // the adapter. Also specify this Activity object, which implements
            // the TabListener interface, as the callback (listener) for when
            // this tab is selected.
            actionBar.addTab(
                    actionBar.newTab()
                            .setText(mSectionsPagerAdapter.getPageTitle(i))
                            .setTabListener(this));
        }  

    }
    
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.box_office_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        // When the given tab is selected, switch to the corresponding page in
        // the ViewPager.
        mViewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position);
        }

        @Override
        public int getCount() {
            // Show 10 total pages.
            return 10;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            Locale l = Locale.getDefault();
            switch (position) {
                case 0:
                    return getString(R.string.title_section1).toUpperCase(l);
                case 1:
                    return getString(R.string.title_section2).toUpperCase(l);
                case 2:
                    return getString(R.string.title_section3).toUpperCase(l);
                case 3:
                    return getString(R.string.title_section4).toUpperCase(l);
                case 4:
                    return getString(R.string.title_section5).toUpperCase(l);
                case 5:
                    return getString(R.string.title_section6).toUpperCase(l);
                case 6:
                    return getString(R.string.title_section7).toUpperCase(l);
                case 7:
                    return getString(R.string.title_section8).toUpperCase(l);
                case 8:
                    return getString(R.string.title_section9).toUpperCase(l);
                case 9:
                    return getString(R.string.title_section10).toUpperCase(l);
            }
            return null;
        }
    }
    
    private static class ViewHolder {
    	ImageView imageView;
    	WebView synopsisWebView;
		TextView titleTextView;
		TextView yearTextView;
		TextView releaseTextView;
		TextView ratingsTextView;
		TextView castsTextView;
	}

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public static ImageLoader imageLoader;
		
		private int mPageNumber;
        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
        	
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            
            imageLoader=new ImageLoader(mContext);
            

            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
		public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			mPageNumber = getArguments().getInt(ARG_SECTION_NUMBER);
		}
        
        public int getPageNumber() {
            return mPageNumber;
        }

		@Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_box_office_main, container, false);

            ViewHolder viewHolder;

            viewHolder = new ViewHolder();
			
			viewHolder.titleTextView = (TextView) rootView
					.findViewById(R.id.titleTextView);
			viewHolder.releaseTextView = (TextView) rootView
					.findViewById(R.id.releaseTextView);
			viewHolder.yearTextView = (TextView) rootView
					.findViewById(R.id.yearTextView);
			viewHolder.ratingsTextView = (TextView) rootView
					.findViewById(R.id.ratingsTextView);
			viewHolder.castsTextView = (TextView) rootView
					.findViewById(R.id.castsTextView);
			viewHolder.synopsisWebView = (WebView) rootView
					.findViewById(R.id.synopsisWebView);
			viewHolder.imageView = (ImageView) rootView
					.findViewById(R.id.imageView);
			rootView.setTag(viewHolder);
			
            Movie m = movies.get(mPageNumber);
            
            viewHolder.titleTextView.setText(m.getTitle());
            viewHolder.yearTextView.setText(m.getYear());
            viewHolder.ratingsTextView.setText(m.getRatings().get("audience_score"));
            viewHolder.releaseTextView.setText(m.getRelease_dates().get("theater"));
            
            String castsString="";
            for(int i=0; i<m.getCasts().size() ; i++){
            	castsString += ("-"+m.getCasts().get(i).getName()+"\n");
            }
            
            viewHolder.castsTextView.setText(castsString);
           
            String youtContentStr = String.valueOf(Html
                    .fromHtml("<![CDATA[<body style=\"text-align:justify;font-size:13px;color:#222222; \">" + m.getSynopsis()+ "</body>]]>"));

            viewHolder.synopsisWebView.loadData(youtContentStr, "text/html", "utf-8");
            
            
            String imageUrl = m.getPosters().get("thumbnail");
            
            imageLoader.DisplayImage(imageUrl, viewHolder.imageView);
            
            return rootView;
        }
    }

}
