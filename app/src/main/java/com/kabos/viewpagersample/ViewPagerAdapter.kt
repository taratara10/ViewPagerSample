package com.kabos.viewpagersample

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter (fragment: Fragment): FragmentStateAdapter(fragment) {
    private val fragmentList = mutableListOf<Fragment>()
    private val idsList = mutableListOf<Long>()


    init {
        fragmentList.apply {
            add(FragmentOne())
            add(FragmentTwo())
            add(FragmentThree())
            forEach {
                idsList.add(it.hashCode().toLong())
            }
        }
    }

    override fun getItemCount(): Int = fragmentList.size

    override fun getItemId(position: Int): Long = idsList[position]

    override fun containsItem(itemId: Long): Boolean = idsList.contains(itemId)

    override fun createFragment(position: Int): Fragment = fragmentList[position]

    fun replaceFragment(pattern: ReplacePattern){

        //FragmentOneをremoveして、FragmentAに置き換える
        if (pattern == ReplacePattern.OneToA) {
            fragmentList.removeFirst()
            fragmentList.add(0, (FragmentA()))
        }

        //FragmentTwoをremoveして、FragmentA , Bに置き換える
        if (pattern == ReplacePattern.TwoToAB){
            fragmentList.removeAt(1)
            fragmentList.add(1, (FragmentA()))
            fragmentList.add(2, (FragmentB()))
        }

        //
        idsList.clear()
        fragmentList.forEach {
            idsList.add(it.hashCode().toLong())
        }

        notifyDataSet(pattern)
    }

    private fun notifyDataSet(pattern: ReplacePattern){
        if (pattern == ReplacePattern.OneToA){
            notifyItemRemoved(0)
            notifyItemInserted(0)
        }
        if (pattern == ReplacePattern.TwoToAB){
            notifyItemRemoved(1)
            notifyItemRangeInserted(1,2)
        }
    }
}

enum class ReplacePattern {
    OneToA,
    TwoToAB
}
