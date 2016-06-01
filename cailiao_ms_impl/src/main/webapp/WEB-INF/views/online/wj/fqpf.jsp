<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<div class="box box-solid box-default">
	<div class="box-header">
		<h4 class="box-title">窑尾烟囱废气</h4>
	</div>
	<div class="box-body">
		<div class="row">
			<div class="col-md-12">
				<div class="box box-default">
					<div class="box-header"><strong class="stress_title">颗粒物</strong></div>
					<div class="box-body">
						<table class="table">
							<tr>
								<th>项目</th>
								<th>窑头<span class="redtag">*</span></th>
								<th>窑尾<span class="redtag">*</span></th>
								<th>水泥磨</th>
								<th>煤磨</th>
								<th>包装机</th>
							</tr>
							<tr>
								<td>年排放量，吨/年</td>
								<td><input type="text" class="form-control" id="fqpf_klw_npfl_yt"></td>
								<td><input type="text" class="form-control" id="fqpf_klw_npfl_yw"></td>
								<td><input type="text" class="form-control" id="fqpf_klw_npfl_snm"></td>
								<td><input type="text" class="form-control" id="fqpf_klw_npfl_mm"></td>
								<td><input type="text" class="form-control" id="fqpf_klw_npfl_bzj"></td>
							</tr>
							<tr>
								<td>排放浓度，mg/m<sup>3</sup></td>
								<td><input type="text" class="form-control" id="fqpf_klw_pfnd_yt"></td>
								<td><input type="text" class="form-control" id="fqpf_klw_pfnd_yw"></td>
								<td><input type="text" class="form-control" id="fqpf_klw_pfnd_snm"></td>
								<td><input type="text" class="form-control" id="fqpf_klw_pfnd_mm"></td>
								<td><input type="text" class="form-control" id="fqpf_klw_pfnd_bzj"></td>
							</tr>
							<!-- <tr>
								<td>除尘方式(电/袋)</td>
								<td><input type="text" class="form-control" id="fqpf_klw_ccfs_yt"></td>
								<td><input type="text" class="form-control" id="fqpf_klw_ccfs_yw"></td>
								<td><input type="text" class="form-control" id="fqpf_klw_ccfs_snm"></td>
								<td><input type="text" class="form-control" id="fqpf_klw_ccfs_mm"></td>
								<td><input type="text" class="form-control" id="fqpf_klw_ccfs_bzj"></td>
							</tr> -->
						</table>
					</div>
				</div>
			</div>
			<div class="col-md-6">
				<div class="box box-default">
					<div class="box-header"><strong class="stress_title">废气</strong></div>
					<div class="box-body">
						<table class="table">
							<tr>
								<th>项目</th>
								<th>SO<sub>2</sub>窑尾<span class="redtag">*</span></th>
								<th>NO<sub>x</sub>窑尾<span class="redtag">*</span></th>
							</tr>
							<tr>
								<td>年排放量，吨/年</td>
								<td><input type="text" class="form-control" id="fqpf_fq_npfl_so2"></td>
								<td><input type="text" class="form-control" id="fqpf_fq_npfl_nox"></td>
							</tr>
							<tr>
								<td>排放浓度，mg/m<sup>3</sup></td>
								<td><input type="text" class="form-control" id="fqpf_fq_pfnd_so2"></td>
								<td><input type="text" class="form-control" id="fqpf_fq_pfnd_nox"></td>
							</tr>
							<!-- <tr>
								<td>除尘方式(电/袋)</td>
								<td><input type="text" class="form-control" id="fqpf_fq_ccfs_so2"></td>
								<td><input type="text" class="form-control" id="fqpf_fq_ccfs_nox"></td>
							</tr> -->
						</table>
						<div class="row"></div>
					</div>
				</div>
			</div>
			<div class="col-md-3">
				<div class="box box-default">
					<div class="box-header">喷氨</div>
					<div class="box-body">
						<div class="form-group">
							<label for="fqpf_pd_sl">喷氨 kg/t熟料</label> 
							<input type="text" class="form-control" id="fqpf_pd_sl" placeholder="">
						</div>
						<div class="form-group">
							<label for="fqpf_pd_ccfs">氨逃逸量 mg/m<sup>3</sup></label> 
							<input type="text" class="form-control" id="fqpf_pd_ccfs" placeholder="">
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-3">
				<div class="box box-default">
					<div class="box-header">脱硝工艺</div>
					<div class="box-body">
						<div class="form-group">
							1 <input type="checkbox" name="fqpf_txgy" value="SNCR" checked> SNCR <br /> 
							2 <input type="checkbox" name="fqpf_txgy" value="分级燃烧"> 分级燃烧 <br /> 
							3 <input type="checkbox" name="fqpf_txgy" value="SNCR 分级燃烧"> 1+2 <br /> 
							4 <input type="checkbox" name="fqpf_txgy" value="其他"> 其他 <br />
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>