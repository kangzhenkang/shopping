package com.haos.dao.recentlyviewed.impl;

import java.util.List;

import com.haos.common.util.dao.BaseDao;
import com.haos.dao.recentlyviewed.RecentlyViewedDao;
import com.haos.domain.recentlyviewed.RecentlyViewed;
import com.haos.domain.recentlyviewed.query.RecentlyViewedQuery;

/**
 * RecentlyViewed information DAO implementation
 * @author WangYue
 *
 */
@SuppressWarnings("rawtypes")
public class RecentlyViewedDaoImpl extends BaseDao implements RecentlyViewedDao {

	@SuppressWarnings("unchecked")
	@Override
	public boolean addRecentlyViewed(RecentlyViewed recentlyViewed) {
		return this.insert("RecentlyViewed.insert", recentlyViewed);
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<RecentlyViewed> queryRecentlyViewedByUserCode(String userCode) {
		return (List<RecentlyViewed>)this.queryForList("RecentlyViewed.queryRecentlyViewedByUserCode", userCode);
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<RecentlyViewed> queryRecentlyViewedListByQueryBean(RecentlyViewedQuery recentlyViewedQuery) {
		return (List<RecentlyViewed>)this.queryForList("RecentlyViewed.queryRecentlyViewedListByQueryBean", recentlyViewedQuery);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RecentlyViewed> queryRecentlyViewedListPageByQueryBean(RecentlyViewedQuery recentlyViewedQuery) {
		return this.queryForList("RecentlyViewed.queryRecentlyViewedListPageByQueryBean", recentlyViewedQuery);
	}							
	@SuppressWarnings("unchecked")
	@Override
	public boolean deleteRecentlyViewedById(Long id) {
		return this.delete("RecentlyViewed.deleteRecentlyViewedById", id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public int queryRecentlyViewedCountByQueryBean(RecentlyViewedQuery recentlyViewedQuery) {
		return (Integer)this.queryForObject("RecentlyViewed.queryRecentlyViewedCountByQueryBean", recentlyViewedQuery);
	}
}
