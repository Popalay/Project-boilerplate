package com.popalay.appname.utils.recycler

import com.github.nitrico.lastadapter.StableId


class StableIdDiffListCallback<in T : StableId> : DiffObservableList.Callback<T> {

    override fun areItemsTheSame(oldItem: T, newItem: T) = oldItem.stableId == newItem.stableId

    override fun areContentsTheSame(oldItem: T, newItem: T) = oldItem == newItem

}
