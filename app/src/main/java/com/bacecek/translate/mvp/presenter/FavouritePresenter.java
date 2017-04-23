package com.bacecek.translate.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.bacecek.translate.App;
import com.bacecek.translate.R;
import com.bacecek.translate.data.db.RealmController;
import com.bacecek.translate.data.entity.Translation;
import com.bacecek.translate.mvp.view.FavouriteView;
import io.realm.RealmResults;
import javax.inject.Inject;

/**
 * Created by Denis Buzmakov on 11/04/2017.
 * <buzmakov.da@gmail.com>
 */

@InjectViewState
public class FavouritePresenter extends MvpPresenter<FavouriteView> {
	@Inject
	RealmController mRealmController;

	private String mCurrentSearchText = "";

	public FavouritePresenter() {
		App.getAppComponent().inject(this);
	}

	@Override
	protected void onFirstViewAttach() {
		super.onFirstViewAttach();
		getViewState().setData(mRealmController.getFavourites());
	}

	public void onItemSwiped(Translation translation) {
		mRealmController.changeFavourite(translation);
	}

	public void onInputChanged(String search) {
		mCurrentSearchText = search;
		if(mCurrentSearchText.isEmpty()) {
			getViewState().setButtonClearVisibility(false);
			getViewState().setEmptyViewText(R.string.empty_list_favourites);
		} else {
			getViewState().setButtonClearVisibility(true);
			getViewState().setEmptyViewText(R.string.empty_search);
		}
		RealmResults<Translation> favourites = mRealmController.getFavourites(mCurrentSearchText);
		getViewState().updateData(favourites);
	}

	public void onDataChanged(int size) {
		if(size == 0) {
			getViewState().setEmptyViewVisibility(true);
			getViewState().setListVisibility(false);
			if(mCurrentSearchText.isEmpty())
				getViewState().setSearchVisibility(false);
		} else {
			getViewState().setEmptyViewVisibility(false);
			getViewState().setListVisibility(true);
			getViewState().setSearchVisibility(true);
		}
	}
}
