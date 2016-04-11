/**
 * 
 */
package com.alpha.puyinapp.fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.alpha.adapter.OrderListFragmentPagerAdapter;
import com.alpha.puyinapp.R;

/**
 * @author Simon
 * @category订单列表fragment 
 *                       三个页面共用一个fragment，由于viewpager会预加载,所以不能根据position的索引来获取数据，
 *                       我们就根据TITLES[position] 适配数据。简单方便
 */
public class OrderListTabFragment extends Fragment {
    private ListView listView;
    int position;

    public OrderListTabFragment() {
        super();
        // TODO Auto-generated constructor stub
    }

    public OrderListTabFragment(int position) {
        this.position = position;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.orderlistgridview, container,
                false);
        listView = (ListView) view.findViewById(R.id.lv_orderlist);
        /*
         * 
         * gridviewde 适配器
         */
        listView.setAdapter(new SimpleAdapter(getContext(), getData(),
                R.layout.listview_orderlist_item, new String[] { "Image",
                        "ordername", "orderprice", "sales" }, new int[] {
                        R.id.iv_orderimage, R.id.tv_ordername,
                        R.id.tv_orderprice, R.id.tv_sales }));
        return view;

    }

    /**
     * 根据TITLES[position ]适配数据
     */
    private List<Map<String, Object>> getData() {
        // TODO Auto-generated method stub
        List<Map<String, Object>> list = new ArrayList<>();
        if (OrderListFragmentPagerAdapter.TITLES[position] == "销量优先") {
            for (int i = 0; i < 10; i++) {
                Map<String, Object> map = new HashMap<>();
                map.put("Image", R.drawable.silver4);
                map.put("ordername",
                        "STEINMETZ18K白金PT950铂金秀气扭臂三爪30 50分钻石戒指砖石钻戒");
                map.put("orderprice", "￥9999");
                map.put("sales", (1999 - 100 * i) + "人付款");
                list.add(map);

            }
        }

        else if (OrderListFragmentPagerAdapter.TITLES[position] == "价格优先") {
            for (int i = 0; i < 10; i++) {
                Map<String, Object> map = new HashMap<>();
                map.put("Image", R.drawable.silver4);
                map.put("ordername",
                        "STEINMETZ18K白金PT950铂金秀气扭臂三爪30 50分钻石戒指砖石钻戒");
                map.put("orderprice", "￥" + (9999 - 100 * i));
                map.put("sales", "1999人付款");
                list.add(map);
            }

        }
        /*
         * 综合排序适配数据
         */
        else if (OrderListFragmentPagerAdapter.TITLES[position] == "综合排序") {
            for (int i = 0; i < 10; i++) {
                Map<String, Object> map = new HashMap<>();
                map.put("Image", R.drawable.silver4);
                map.put("ordername",
                        "STEINMETZ18K白金PT950铂金秀气扭臂三爪30 50分钻石戒指砖石钻戒");
                map.put("orderprice", "$9999");
                map.put("sales", "1999人付款");
                list.add(map);
            }
        }
        return list;
    }
}
