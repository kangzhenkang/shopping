<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<jsp:include page="common/head.jsp" />
<%@ taglib uri="/struts-tags" prefix="s"%>
<script language="javascript">
  

  function addToCart(id){
	   if(id!=''&&id.length>0){
		   jQuery.ajax({
				type : "post",
				url : "shoppingCartJson_addShoppingCart.action",
				dataType : 'text',
				data : {commodityId:id},
				success : function(json) {

					if (json != null && json != '') {
						var member = eval(json); //包数据解析为json 格式
						var jsons = member.split("*");
						if (jsons[0] == "true") {
							alert('加入成功!');
						} else {
							if (undefined != jsons[1]) {
								
								alert(jsons[1]);
								if('您还没有登录'==jsons[1]){
									window.self.location="toLogin.action";
								}
							} else {
								alert("加入失败！");
							}
						}
					} else {
						alert("异步处理异常，返回值为空！");
					}
				}
			});
		   
	   }
	   
  }
  
  function addFavorites(id){
	   	if(id.length>0&&id!=''){
	   		jQuery.ajax({
				type : "post",
				url : "favoritesJson_addFavorites.action",
				dataType : 'text',
				data : {commodityId:id},
				success : function(json) {

					if (json != null && json != '') {
						var member = eval(json); //包数据解析为json 格式
						var jsons = member.split("*");
						if (jsons[0] == "true") {
							alert('收藏成功!');
						} else {
							if (undefined != jsons[1]) {
								alert(jsons[1]);
							} else {
								alert("收藏失败！");
							}
						}
					} else {
						alert("异步处理异常，返回值为空！");
					}
				}
			});
	   	}
	   	
	   }
  
  function addRecentlyViewed(id){
	  	if(id.length>0&&id!=''){
	   		jQuery.ajax({
				type : "post",
				url : "recentlyViewedJson_addRecentlyViewed.action",
				dataType : 'text',
				data : {commodityId:id},
				success : function(json) {

					if (json != null && json != '') {
						var member = eval(json); //包数据解析为json 格式
						var jsons = member.split("*");
						if (jsons[0] == "false") {
							if('notlogin'!=jsons[i]){
								
								if (undefined != jsons[1]) {
										alert(jsons[1]);
									} else {
										alert("添加浏览失败！");
									}
								}
							}
					} else {
						alert("异步处理异常，返回值为空！");
					}
				}
			});
	   	}
	
	}
  
   function listView(){
	   $("#listView").show();
	   $("#gridView").hide();
   }
   
   function gridView(){
	   $("#gridView").show();
	   $("#listView").hide();
   }
  
  </script>
<body>
	<!-- Wrapper -->
	<div id="wrapper_sec">
		<!-- Header -->
		<!--navigation part   -->
		<jsp:include page="common/navigation.jsp" />
		<div class="clear"></div>
		<div id="crumb">
			<ul>
				<li><a href="index.action">首页</a>
				</li>
				<li class="last"><a href="#" class="colr bold">产品</a>
				</li>
			</ul>
		</div>
		<div class="clear"></div>
		<!-- Content Section -->
		<div id="content_sec">
			<!-- Left -->
			<jsp:include page="common/left.jsp" />
			<!-- Column 2 -->
			<div class="col2">
				<!-- Small Banner -->
				<!--<div class="small_banner">
            	<a href="#"><img src="images/small_banner.gif" alt="" /></a>
            </div>
            -->
				<div class="clear"></div>
				<!-- Listing -->

				<div class="listing">
					<!-- Sorting -->
					<div class="sorting">
						<div class="leftsort">
							<h2 class="colr upper bold">Products</h2>
							<p>Items 1 to 8 of 12 total</p>
						</div>
						<div class="sortby">
							<p>Sort By</p>
							<div class="selectmenu">
								<select name="speedC" id="speedE">
									<option value="Slower" class="whoo">English</option>
									<option value="Slow">Deutsch</option>
									<option value="Slow">Russian</option>
								</select>
							</div>
						</div>
						<div class="showperpage">
							<p>Show</p>
							<div class="selectmenu">
								<select name="speedC" id="speedF">
									<option value="Slower" class="whoo">8</option>
									<option value="Slow">16</option>
									<option value="Slow">24</option>
								</select>
							</div>
						</div>
						<div class="gridlist">
							<a href="#" class="list" onclick="listView()"></a> <a href="#"
								class="grid selected" onclick="gridView()"></a>
						</div>
					</div>
					<div class="clear"></div>



					<!-- Listing Products -->
					<ul id="gridView" class="listingprods">
						<s:if test="commodityList.size>0">
							<s:iterator value="commodityList" status="status">
								<s:if test="status.index%4==0">
									<li class="last"><a
										href="detail.action?id=<s:property value="id"/>"
										onclick="addRecentlyViewed('<s:property value="id"/>')"
										class="thumb"> <s:if test="commodityPhoto!=null">
												<s:generator separator=";" val="commodityPhoto">
													<s:iterator status="status">
														<s:if test="#status.index==0">
															<img src="../commodityImages/<s:property/>" width="121"
																height="121" />
														</s:if>

													</s:iterator>

												</s:generator>

											</s:if> <s:else>
												<img src="../commodityImages/<s:property/>" width="121"
													height="121" />
											</s:else> </a>
										<h6>
											<a href="detail.action?id=<s:property value="id"/>"
												onclick="addRecentlyViewed('<s:property value="id"/>')"
												class="colr bold"><s:property value="commodityName" />
											</a>
										</h6>
										<div class="rating">
											<div class="stars">
												<a href="#">&nbsp;</a> <a href="#">&nbsp;</a> <a href="#">&nbsp;</a>
												<a href="#">&nbsp;</a> <a href="#" class="gry">&nbsp;</a>
											</div>
											<a href="#" class="reviews">浏览<s:property
													value="viewedCount" default="0" />次</a>
										</div>
										<div class="prices">
											<s:if test="newPrice!=null&&newPrice<price">
												<p class="newprice">
													￥
													<s:property value="newPrice" />
												</p>
											</s:if>
											<s:else>
												<p class="oldprice">
													￥
													<s:property value="price" />
												</p>
											</s:else>
										</div>
										<div class="cartse">
											<a href="#" onclick="addToCart('<s:property value="id"/>')"
												class="buttonone">加入购物车</a> <a href="#"
												onclick="addFavorites('<s:property value="id"/>')"
												class="favo">&nbsp;</a>
										</div></li>
								</s:if>
								<s:else>
									<li><a href="detail.action?id=<s:property value="id"/>"
										onclick="addRecentlyViewed('<s:property value="id"/>')"
										class="thumb"> <s:if test="commodityPhoto!=null">
												<s:generator separator=";" val="commodityPhoto">
													<s:iterator status="status">
														<s:if test="#status.index==0">
															<img src="../commodityImages/<s:property/>" width="121"
																height="121" />
														</s:if>

													</s:iterator>

												</s:generator>

											</s:if> <s:else>
												<img src="../commodityImages/<s:property/>" width="121"
													height="121" />
											</s:else> </a>
										<h6>
											<a href="detail.action?id=<s:property value="id"/>"
												onclick="addRecentlyViewed('<s:property value="id"/>')"
												class="colr bold"><s:property value="commodityName" />
											</a>
										</h6>
										<div class="rating">
											<div class="stars">
												<a href="#">&nbsp;</a> <a href="#">&nbsp;</a> <a href="#">&nbsp;</a>
												<a href="#">&nbsp;</a> <a href="#" class="gry">&nbsp;</a>
											</div>
											<a href="#" class="reviews">浏览<s:property
													value="viewedCount" default="0" />次</a>
										</div>
										<div class="prices">
											<s:if test="newPrice!=null&&newPrice<price">
												<p class="newprice">
													￥
													<s:property value="newPrice" />
												</p>
											</s:if>
											<s:else>
												<p class="oldprice">
													￥
													<s:property value="price" />
												</p>
											</s:else>
										</div>
										<div class="cartse">
											<a href="#" onclick="addToCart('<s:property value="id"/>')"
												class="buttonone">加入购物车</a> <a href="#"
												onclick="addFavorites('<s:property value="id"/>')"
												class="favo">&nbsp;</a>
										</div></li>

								</s:else>

							</s:iterator>


						</s:if>
						<s:else>
                  		暂无商品
                  </s:else>
					</ul>


					<div class="clear"></div>






					<!-- Listing Big -->
					<ul id="listView" class="listinglist" style="display: none;">

						<s:if test="commodityList.size>0">
							<s:iterator value="commodityList">
								<li>
									<div class="thumb">
										<a href="detail.action?id=<s:property value="id"/>"
											onclick="addRecentlyViewed('<s:property value="id"/>')">
											<s:if test="commodityPhoto!=null">
												<s:generator separator=";" val="commodityPhoto">
													<s:iterator status="status">
														<s:if test="#status.index==0">
															<img src="../commodityImages/<s:property/>" width="121"
																height="121" />
														</s:if>

													</s:iterator>

												</s:generator>

											</s:if> <s:else>
												<img src="../commodityImages/<s:property/>" width="121"
													height="121" />
											</s:else> </a>
									</div>
									<div class="desc">
										<h5>
											<a href="detail.action?id=<s:property value="id"/>"
												onclick="addRecentlyViewed('<s:property value="id"/>')"
												class="colr bold"><s:property value="commodityName" />
											</a>
										</h5>
										<div class="rating">
											<div class="stars">
												<a href="#">&nbsp;</a> <a href="#">&nbsp;</a> <a href="#">&nbsp;</a>
												<a href="#">&nbsp;</a> <a href="#" class="gry">&nbsp;</a>
											</div>
											<a href="#" class="reviews">浏览<s:property
													value="viewedCount" default="0" />次</a>
										</div>
										<p class="txt">
											<s:property value="quickOverride" escape="false" />
										</p>
										<div class="prices">
											<s:if test="newPrice!=null&&newPrice<price">
												<p class="newprice">
													￥
													<s:property value="newPrice" />
												</p>
											</s:if>
											<s:else>
												<p class="oldprice">
													￥
													<s:property value="price" />
												</p>
											</s:else>
											<a href="#" onclick="addToCart('<s:property value="id"/>')"
												class="buttonone">加入购物车</a> <a href="#"
												onclick="addFavorites('<s:property value="id"/>')"
												class="favo">&nbsp;</a>
										</div>
									</div></li>
							</s:iterator>

						</s:if>
						<s:else>
                    	暂无商品
                    </s:else>



					</ul>
					<div class="clear"></div>
					<div class="paging">
						<ul>
							<li class="bold txt">Page:</li>
							<li><a href="#" class="numbr">1</a>
							</li>
							<li><a href="#" class="numbr">2</a>
							</li>
							<li><a href="#" class="numbr selected">3</a>
							</li>
							<li><a href="#" class="numbr">4</a>
							</li>
							<li><a href="#" class="numbr">5</a>
							</li>
							<li>...</li>
							<li><a href="#" class="numbr">18</a>
							</li>
						</ul>
					</div>
				</div>
			</div>
			<div class="clear"></div>

		</div>
		<div class="clear"></div>
		<!-- Footer -->
		<jsp:include page="common/bottom.jsp" />
		<div class="clear"></div>
	</div>
</body>
</html>
