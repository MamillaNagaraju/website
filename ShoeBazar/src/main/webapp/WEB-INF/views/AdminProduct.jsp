<%@include file="AdminHeader.jsp"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script>

	<c:url var="addAction" value="addproduct"></c:url>
	<div>
		<div class="w3-row">
			<div class="w3-container w3-third"></div>
			<div class="w3-container w3-third">
				<form:form action="${addAction}" commandName="product" enctype="multipart/form-data" method="post">
					<table class="w3-table w3-bordered w3-striped w3-card-4">
						<tr class="w3-cyan">
							<th colspan="2">Add Product</th>
						</tr>
						<tr>
							<td><form:label path="pid">
									<spring:message text="Id" />
								</form:label></td>
							<c:choose>
								<c:when test="${!empty product.pid}">
									<td><form:input path="id" readonly="true" />
									</td>
								</c:when>

								<c:otherwise>
									<td><form:input path="pid" /></td>
								</c:otherwise>
							</c:choose>
						<tr>
							<td><form:label path="name">
									<spring:message text="Name" />
								</form:label></td>
							<td><form:input path="name" required="true" /></td>
						</tr>
						<tr>
							<td><form:label path="description">
									<spring:message text="Description" />
								</form:label></td>
							<td><form:input path="description" required="true" /></td>
						</tr>
						<tr>
							<td><form:label path="price">
									<spring:message text="Price" />
								</form:label></td>
							<td><form:input path="price" required="true" /></td>
						</tr>
						<tr>
							<td><form:label path="supplierid">
									<spring:message text="Supplier" />
								</form:label></td>
							<td><form:select path="supplierid" required="true">
							<c:forEach items="${supplierList}" var="supplier">
								<form:option value="${supplier.id}">${supplier.name}</form:option>
							</c:forEach>
								</form:select></td>
						</tr>
						<tr>
							<td><form:label path="categoryid">
									<spring:message text="Category" />
								</form:label></td>
							<td><form:select path="categoryid" required="true">
							<c:forEach items="${categoryList}" var="category">
								<form:option value="${category.id}">${category.name}</form:option>
							</c:forEach>
								</form:select></td>
						</tr>
						<tr>
							<td><form:label path="image">
									<spring:message text="Image" />
								</form:label></td>
							<td><form:input type="file" path="image" required="true" /></td>
						</tr>
						<tr>
							<td colspan="2"><c:if test="${!empty product.name}">
									<input type="submit" class="w3-btn w3-blue"
										value="<spring:message text="Edit product"/>" />
								</c:if> <c:if test="${empty product.name}">
									<input type="submit" class="w3-btn w3-blue"
										value="<spring:message text="Add product"/>" />
								</c:if></td>
						</tr>
					</table>
				</form:form>
			</div>
		</div>
		<div class="w3-container w3-third"></div>
		<br>
		<div class="w3-row">
			<div class="w3-container w3-quarter"></div>
			<div class="w3-container w3-half">

				<c:if test="${!empty productList}">
					<table class="w3-table w3-bordered w3-striped w3-card-4">
						<tr class="w3-cyan">
							<th>Product ID</th>
							<th>Product Name</th>
							<th>Product Description</th>
							<th>Product Price</th>
							<th>Supplier Id</th>
							<th>Product Id</th>
							<th>Edit</th>
							<th>Delete</th>
						</tr>
						<c:forEach items="${productList}" var="product">
							<tr>
								<td>${product.pid}</td>
								<td>${product.name}</td>
								<td>${product.description}</td>
								<td>${product.price}</td>
								<td>${product.supplierid}</td>
								<td>${product.categoryid}</td>
								<td>
									<form action="editproduct/${product.pid}" method="post">
										<input type="submit" value="Edit" class="w3-btn w3-blue">
									</form>
								</td>
								<td><form action="removeproduct/${product.pid}">
										<input type="submit" value="Delete" class="w3-btn w3-blue">
									</form></td>
							</tr>
						</c:forEach>
					</table>
				</c:if>
			</div>
			<div class="w3-container w3-quarter"></div>
		</div>
	</div>
</body>
</html>