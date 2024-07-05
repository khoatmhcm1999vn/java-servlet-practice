<%@ include file="/common/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Danh sách bài viết</title>
</head>
<body>
<div class="main-content">
	<form action="<c:url value='/admin-news'/>" id="formSubmit" method="get">
		<div class="table-responsive">
			<table class="table table-bordered">
				<thead>
					<tr>
						<th><input type="checkbox" id="checkAll"></th>
						<th>Tên bài viết</th>
						<th>Mô tả ngắn</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${model.listResult}">
						<tr>
							<td><input type="checkbox" id="checkbox_${item.id}" value="${item.id}"></td>
							<td>${item.title}</td>
							<td>${item.shortDescription}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<ul class="pagination" id="pagination"></ul>
			<input type="hidden" value="" id="page" name="page"/>
			<input type="hidden" value="" id="maxPageItem" name="maxPageItem"/>
			<input type="hidden" value="" id="sortName" name="sortName"/>
			<input type="hidden" value="" id="sortBy" name="sortBy"/>
		</div>
	</form>
</div>

<script type="text/javascript">
    var currentPage = ${model.page}
    var totalPage = ${model.totalPage}
    var limit = 2;

    $(function() {
        window.pagObj = $('#pagination').twbsPagination({
            totalPages : totalPage,
            visiblePages : 10,
            startPage : currentPage,
            onPageClick : function(event, page) {
                if (currentPage != page) {
                    $('#maxPageItem').val(limit);
                    $('#page').val(page);
                    $('#sortName').val("title");
                    $('#sortBy').val("desc");
                    $('#formSubmit').submit();
                }
            }
        }).on('page', function(event, page) {
            console.info(page + ' (from event listening)');
        });
    });
</script>
</body>
</html>