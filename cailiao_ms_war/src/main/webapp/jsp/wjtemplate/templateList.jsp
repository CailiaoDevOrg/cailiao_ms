<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<div id="table-datatables">
	<div class="row">
		<div class="col s12 m12 l12">
			<div id="data-table-simple_wrapper" class="dataTables_wrapper">
				<h4 class="header">问卷模板管理</h4>
				<table id="data-table-simple"
					class="responsive-table display dataTable" cellspacing="0"
					role="grid" aria-describedby="data-table-simple_info">
					<thead>
						<tr role="row">
							<th class="sorting" tabindex="0"
								aria-controls="data-table-simple" rowspan="1" colspan="1"
								aria-label="Name: activate to sort column ascending"
								style="width: 135px;">Name</th>
							<th class="sorting_asc" tabindex="0"
								aria-controls="data-table-simple" rowspan="1" colspan="1"
								aria-label="Position: activate to sort column descending"
								style="width: 222px;" aria-sort="ascending">Position</th>
							<th class="sorting" tabindex="0"
								aria-controls="data-table-simple" rowspan="1" colspan="1"
								aria-label="Office: activate to sort column ascending"
								style="width: 96px;">Office</th>
							<th class="sorting" tabindex="0"
								aria-controls="data-table-simple" rowspan="1" colspan="1"
								aria-label="Age: activate to sort column ascending"
								style="width: 37px;">Age</th>
							<th class="sorting" tabindex="0"
								aria-controls="data-table-simple" rowspan="1" colspan="1"
								aria-label="Start date: activate to sort column ascending"
								style="width: 84px;">Start date</th>
							<th class="sorting" tabindex="0"
								aria-controls="data-table-simple" rowspan="1" colspan="1"
								aria-label="Salary: activate to sort column ascending"
								style="width: 75px;">Salary</th>
						</tr>
					</thead>
					<tbody>
						<tr role="row" class="odd">
							<td class="">Airi Satou</td>
							<td class="sorting_1">Accountant</td>
							<td>Tokyo</td>
							<td class="">33</td>
							<td>2008/11/28</td>
							<td class="">$162,700</td>
						</tr>
						<tr role="row" class="even">
							<td class="">Garrett Winters</td>
							<td class="sorting_1">Accountant</td>
							<td>Tokyo</td>
							<td class="">63</td>
							<td>2011/07/25</td>
							<td class="">$170,750</td>
						</tr>
						<tr role="row" class="odd">
							<td class="">Angelica Ramos</td>
							<td class="sorting_1">Chief Executive Officer (CEO)</td>
							<td>London</td>
							<td class="">47</td>
							<td>2009/10/09</td>
							<td class="">$1,200,000</td>
						</tr>
						<tr role="row" class="even">
							<td class="">Paul Byrd</td>
							<td class="sorting_1">Chief Financial Officer (CFO)</td>
							<td>New York</td>
							<td class="">64</td>
							<td>2010/06/09</td>
							<td class="">$725,000</td>
						</tr>
						<tr role="row" class="odd">
							<td class="">Yuri Berry</td>
							<td class="sorting_1">Chief Marketing Officer (CMO)</td>
							<td>New York</td>
							<td class="">40</td>
							<td>2009/06/25</td>
							<td class="">$675,000</td>
						</tr>
						<tr role="row" class="even">
							<td class="">Fiona Green</td>
							<td class="sorting_1">Chief Operating Officer (COO)</td>
							<td>San Francisco</td>
							<td class="">48</td>
							<td>2010/03/11</td>
							<td class="">$850,000</td>
						</tr>
						<tr role="row" class="odd">
							<td class="">Donna Snider</td>
							<td class="sorting_1">Customer Support</td>
							<td>New York</td>
							<td class="">27</td>
							<td>2011/01/25</td>
							<td class="">$112,000</td>
						</tr>
						<tr role="row" class="even">
							<td class="">Serge Baldwin</td>
							<td class="sorting_1">Data Coordinator</td>
							<td>Singapore</td>
							<td class="">64</td>
							<td>2012/04/09</td>
							<td class="">$138,575</td>
						</tr>
						<tr role="row" class="odd">
							<td class="">Gavin Joyce</td>
							<td class="sorting_1">Developer</td>
							<td>Edinburgh</td>
							<td class="">42</td>
							<td>2010/12/22</td>
							<td class="">$92,575</td>
						</tr>
						<tr role="row" class="even">
							<td class="">Jonas Alexander</td>
							<td class="sorting_1">Developer</td>
							<td>San Francisco</td>
							<td class="">30</td>
							<td>2010/07/14</td>
							<td class="">$86,500</td>
						</tr>
					</tbody>
				</table>
				<div class="dataTables_paginate paging_simple_numbers"
					id="data-table-simple_paginate">
					<a class="paginate_button previous disabled"
						aria-controls="data-table-simple" data-dt-idx="0" tabindex="0"
						id="data-table-simple_previous">Previous</a><span><a
						class="paginate_button current" aria-controls="data-table-simple"
						data-dt-idx="1" tabindex="0">1</a><a class="paginate_button "
						aria-controls="data-table-simple" data-dt-idx="2" tabindex="0">2</a><a
						class="paginate_button " aria-controls="data-table-simple"
						data-dt-idx="3" tabindex="0">3</a><a class="paginate_button "
						aria-controls="data-table-simple" data-dt-idx="4" tabindex="0">4</a><a
						class="paginate_button " aria-controls="data-table-simple"
						data-dt-idx="5" tabindex="0">5</a><a class="paginate_button "
						aria-controls="data-table-simple" data-dt-idx="6" tabindex="0">6</a></span><a
						class="paginate_button next" aria-controls="data-table-simple"
						data-dt-idx="7" tabindex="0" id="data-table-simple_next">Next</a>
				</div>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript"
	src="assets/materialize/js/data-tables-script.js"></script>

