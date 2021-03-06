package com.haos.dao.comment;

import java.util.List;

import com.haos.domain.comment.Comment;
import com.haos.domain.comment.query.CommentQuery;


/**
 * Comment information DAO interface
 * @author WangYue
 *
 */
public interface CommentDao {

	/**
	 * add comment information
	 * @param comment   comment value class
	 * @return true:success;false:fail
	 */
	public boolean addComment(Comment comment);
	
	/**
	 * update comment information
	 * @param comment  comment value class
	 * @return true:success;false:fail
	 */
	public boolean updateComment(Comment comment);
	
	/**
	 * according to comment id ,query comment information.
	 * @param id  comment id
	 * @return  Comment  comment value class
	 */
	public Comment getCommentById(Long id);
	
	/**
	 * according to comment query ,query comment information.
	 * @param commentCode  comment code
	 * @return Comment  comment value class
	 */
	public Comment getCommentByCommodityIdAndUserCode(CommentQuery commentQuery);
	
	/**
	 * query all comment information
	 * @param query  Query comment value class
	 * @return Comment  comment value class
	 */
	public List<Comment> queryCommentListByQueryBean(CommentQuery commentQuery);
	
	/**
	 * query comment information with page
	 * @param query Query comment value class
	 * @return Comment comment value class
	 */
	public List<Comment> queryCommentListPageByQueryBean(CommentQuery commentQuery);
	
	/**
	 * according to comment id,delete comment information.
	 * @param id  comment id
	 * @return true:success;false:fail.
	 */
	public boolean deleteCommentById(Long id);
	
	/**
	 * get comment records 
	 * @param query  Query comment value class 
	 * @return comment count 
	 */
	public int queryCommentCountByQueryBean(CommentQuery commentQuery);
	
	
}
