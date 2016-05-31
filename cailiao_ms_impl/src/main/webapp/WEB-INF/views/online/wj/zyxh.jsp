<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<div class="box box-solid box-primary">
	<div class="box-header">
		<h4 class="box-title">资源消耗</h4>
	</div>
	<div class="box-body">
		<div class="row">
			<div class="col-md-6">
				<div class="box box-default">
					<div class="box-header"><strong class="stress_title">熟料烧成用原材料(含替代原料)</strong></div>
					<div class="box-body">
						<table class="table">
							<tr>
								<th>#</th>
								<th>原材料名称</th>
								<th>消耗情况(万吨/年)</th>
							</tr>
							<tr>
								<td>原料 1#</td>
								<td><input type="text" class="form-control" placeholder="如：石灰石" id="zyxh_sl_yclName_1"></td>
								<td><input type="text" class="form-control" id="zyxh_sl_yclXhqk_1"></td>
							</tr>
							<tr>
								<td>原料 2#</td>
								<td><input type="text" class="form-control" id="zyxh_sl_yclName_2"></td>
								<td><input type="text" class="form-control" id="zyxh_sl_yclXhqk_2"></td>
							</tr>
							<tr>
								<td>原料 3#</td>
								<td><input type="text" class="form-control" id="zyxh_sl_yclName_3"></td>
								<td><input type="text" class="form-control" id="zyxh_sl_yclXhqk_3"></td>
							</tr>
							<tr>
								<td>原料 4#</td>
								<td><input type="text" class="form-control" id="zyxh_sl_yclName_4"></td>
								<td><input type="text" class="form-control" id="zyxh_sl_yclXhqk_4"></td>
							</tr>
							<tr>
								<td>原料 5#</td>
								<td><input type="text" class="form-control" id="zyxh_sl_yclName_5"></td>
								<td><input type="text" class="form-control" id="zyxh_sl_yclXhqk_5"></td>
							</tr>
							<tr>
								<td>原料 6#</td>
								<td><input type="text" class="form-control" id="zyxh_sl_yclName_6"></td>
								<td><input type="text" class="form-control" id="zyxh_sl_yclXhqk_6"></td>
							</tr>
						</table>
					</div>
				</div>
			</div>
			<div class="col-md-6">
				<div class="box box-default">
					<div class="box-header stress_title"><strong>燃料(含替代燃料)</strong></div>
					<div class="box-body">
						<table class="table">
							<tr>
								<th>#</th>
								<th>原材料名称</th>
								<th>消耗情况(万吨/年)</th>
							</tr>
							<tr>
								<td>燃料 1#</td>
								<td><input type="text" class="form-control" placeholder="如：石灰石" id="zyxh_rl_yclName_1"></td>
								<td><input type="text" class="form-control" id="zyxh_rl_yclXhqk_1"></td>
							</tr>
							<tr>
								<td>燃料 2#</td>
								<td><input type="text" class="form-control" id="zyxh_rl_yclName_2"></td>
								<td><input type="text" class="form-control" id="zyxh_rl_yclXhqk_2"></td>
							</tr>
							<tr>
								<td>燃料 3#</td>
								<td><input type="text" class="form-control" id="zyxh_rl_yclName_3"></td>
								<td><input type="text" class="form-control" id="zyxh_rl_yclXhqk_3"></td>
							</tr>
						</table>
					</div>
				</div>
			</div>
			<div class="col-md-6">
				<div class="box box-default">
					<div class="box-header">熟料产量(万吨/年)</div>
					<div class="box-body">
						<div class="form-group">
							<input type="text" class="form-control" id="zyxh_slcl" placeholder="熟料产量:万吨/年">
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<div class="box box-default">
					<div class="box-header"><strong class="stress_title">水泥制成用原材料(含替代原料)</strong></div>
					<div class="box-body">
						<table class="table">
							<tr>
								<th>#</th>
								<th>原材料名称</th>
								<th>消耗情况(万吨/年)</th>
								<th>#</th>
								<th>原材料名称</th>
								<th>消耗情况(万吨/年)</th>
							</tr>
							<tr>
								<th>原料 1＃</th>
								<td><input type="text" class="form-control" id="zyxh_sn_yclName_1" placeholder="如：天然石膏"></td>
								<td><input type="text" class="form-control" id="zyxh_sn_yclXhqk_1"></td>
								<th>原料 6＃</th>
								<td><input type="text" class="form-control" id="zyxh_sn_yclName_6"></td>
								<td><input type="text" class="form-control" id="zyxh_sn_yclXhqk_6"></td>
							</tr>
							<tr>
								<th>原料 2＃</th>
								<td><input type="text" class="form-control" id="zyxh_sn_yclName_2"></td>
								<td><input type="text" class="form-control" id="zyxh_sn_yclXhqk_2"></td>
								<th>原料 7＃</th>
								<td><input type="text" class="form-control" id="zyxh_sn_yclName_7"></td>
								<td><input type="text" class="form-control" id="zyxh_sn_yclXhqk_7"></td>
							</tr>
							<tr>
								<th>原料 3＃</th>
								<td><input type="text" class="form-control" id="zyxh_sn_yclName_3"></td>
								<td><input type="text" class="form-control" id="zyxh_sn_yclXhqk_3"></td>
								<th>原料 8＃</th>
								<td><input type="text" class="form-control" id="zyxh_sn_yclName_8"></td>
								<td><input type="text" class="form-control" id="zyxh_sn_yclXhqk_8"></td>
							</tr>
							<tr>
								<th>原料 4＃</th>
								<td><input type="text" class="form-control" id="zyxh_sn_yclName_4"></td>
								<td><input type="text" class="form-control" id="zyxh_sn_yclXhqk_4"></td>
								<th>原料 9＃</th>
								<td><input type="text" class="form-control" id="zyxh_sn_yclName_9"></td>
								<td><input type="text" class="form-control" id="zyxh_sn_yclXhqk_9"></td>
							</tr>
							<tr>
								<th>原料 5＃</th>
								<td><input type="text" class="form-control" id="zyxh_sn_yclName_5"></td>
								<td><input type="text" class="form-control" id="zyxh_sn_yclXhqk_5"></td>
								<th>原料 10＃</th>
								<td><input type="text" class="form-control" id="zyxh_sn_yclName_10"></td>
								<td><input type="text" class="form-control" id="zyxh_sn_yclXhqk_10"></td>
							</tr>
						</table>
						<div class="box-body">
							<label for="zyxh_sncl">水泥产量(万吨/年)</label>
							<input type="text" class="form-control" id="zyxh_sncl" placeholder="水泥产量:万吨/年">
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>