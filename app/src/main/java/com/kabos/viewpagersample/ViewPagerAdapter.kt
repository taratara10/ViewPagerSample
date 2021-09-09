package com.kabos.viewpagersample

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter (fragment: Fragment): FragmentStateAdapter(fragment) {
    private var replacePattern = ReplacePattern.A
    private var fragmentList = mutableListOf<Fragment>()
    private var idsList = mutableListOf<Long>()


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

    override fun getItemCount(): Int = idsList.size

    override fun getItemId(position: Int): Long = idsList[position]

    override fun containsItem(itemId: Long): Boolean = idsList.contains(itemId)

    override fun createFragment(position: Int): Fragment = fragmentList[position]


    fun addFragment(pattern: ReplacePattern){
        this.replacePattern = pattern

        //FragmentOneを削除
        //fragmentList = [FragmentTwo, FragmentThree]
        fragmentList.removeFirst()
        idsList.removeFirst()


        if (replacePattern == ReplacePattern.A) {

            fragmentList.add(0, (FragmentA()))
            fragmentList.first() {
                idsList.add(it.hashCode().toLong())
            }
        }
        if (replacePattern == ReplacePattern.AB){
            fragmentList.add(0, (FragmentA()))
            fragmentList.add(1, (FragmentB()))

            //Assign unique id to each fragment
            idsList.add(fragmentList[0].hashCode().toLong())
            idsList.add(fragmentList[1].hashCode().toLong())
        }


        notifyDataSet()
    }

    fun notifyDataSet(){
        if (replacePattern == ReplacePattern.A){
            notifyItemRemoved(0)
            notifyItemInserted(0)
        }
        if (replacePattern == ReplacePattern.AB){
            notifyItemRemoved(0)
            notifyItemRangeInserted(0,2)
        }
    }
}

enum class ReplacePattern {
    A,
    AB
}
