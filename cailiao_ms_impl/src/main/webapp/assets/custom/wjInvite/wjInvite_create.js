(function($) {    
    $(function() {
        var data_all=[];
        var province_all=[{"id":"-1","text":"全部"}];
        var city_all=[{"id":"-1","text":"全部"}]
        var area=[
                {
                "id":"-1",
                "text":"全部"
                },
                {
                "id":"0",
                "text":"华北地区京津冀蒙晋"
                },
                {
                "id":"1",
                "text":"东北地区黑吉辽"
                },
                {
                "id":"2",
                "text":"华东地区沪皖闽苏赣鲁浙"
                },
                {
                "id":"5",
                "text":"西北地区陇宁青陕新"
                },
                {
                "id":"4",
                "text":"西南地区渝川黔藏云"
                },
                {
                "id":"3",
                "text":"中南地区粤桂琼豫鄂湘"
                }
        ];

        $("#area").select2({
            data:area
        });
        $('#province_select').select2({
            data:[{id:0,text:"全部"}]
        });
        $('#city_select').select2({
           data:[{id:0,text:"全部"}]
        });

        $('#company_select').select2({
            data:[{id:0,text:"全部"}]
        });

        $.ajax({
            url : 'assets/test/test.json',
            method: 'GET',
            dataType : "json",
            success : function(data){
                data_all=data.data;//dataall为全部json数据
                for (var i = 0; i < data_all.length; i++) {
                    province_all.push({id:data_all[i].id,text:data_all[i].name});
                };
                console.log(province_all);
            },
            error : function(data){
                 alert('网络出现问题，请稍后重试');
            }
        })

        //对象转为数组
        function transToArry(jsonobj){
            var select_data=[];
            for (var i = 0; i < jsonobj.length; i++) {
                   select_data.push({id:jsonobj[i].id,text:jsonobj[i].text});
                };
            return select_data;
        };

        //划分地区
        /*function dividearea(obj,area){
            var province=[];
            province.push({id:-1,text:"全部"});
            for (var i = 0; i < obj.length; i++) {
                if(obj[i].area==area){
                    province.push({id:obj[i].id,text:obj[i].text});
                }
            };
            return province;
        }*/

        $('#area').on("change", function (e) {
            var area_id = $('#area').val();
            var province=[];
            province.push({id:-1,text:"全部"});
            for (var i = 0; i < data_all.length; i++) {
                if(data_all[i].area==area_id){
                    province.push({id:i,text:data_all[i].name});
                }
            };
            $("#province_select").select2('destroy');
            $("#province_select").children().remove();
            console.log(province);
            if(province.length == 1) {
                    $('#province_select').select2({
                        data:province_all
                    }); 
                } else {
                    $('#province_select').select2({
                        data:province
                    }); 
                    $("#city_select").select2('destroy');
                    $("#city_select").children().remove();
                    $('#city_select').select2({
                        data:[{id:0,text:"全部"}]
                    });
                }
            
            $("#city_select").select2('destroy');
            $("#city_select").children().remove();
            $('#city_select').select2({
                data:[{id:0,text:"全部"}]
             });
            $("#company_select").select2('destroy');
            $("#company_select").children().remove();
            $('#company_select').select2({
                data:[{id:0,text:"全部"}]
             });


           // var province_name = $('#area>option[value="' + province_id + '"]').text();
            /*$.ajax({
                url: 'assets/test/province.json',
                method: 'GET',
                dataType:"json",
                success: function(data){
                    var province=data.data;
                    if (area_id == '-1') {//如果为全部，则返回所有省份
                    var province_all=transToArry(province);
                    $("#province_select").select2('destroy');
                        $("#province_select").children().remove();
                        $('#province_select').select2({
                           data:province_all
                        }); 

                        $("#city_select").select2('destroy');
                        $("#city_select").children().remove();
                        $('#city_select').select2({
                            data:[{id:0,text:"全部"}]
                         });

                    }else{
                        var province_data=dividearea(province,area_id);
                        $("#province_select").select2('destroy');
                        $("#province_select").children().remove();
                        $('#province_select').select2({
                           data:province_data
                        });

                        $("#city_select").select2('destroy');
                        $("#city_select").children().remove();
                        $('#city_select').select2({
                            data:[{id:0,text:"全部"}]
                         });
                    }
                },
                error: function(data) {
                                alert('网络出现问题，请稍后重试');
                }
            });*/
        });

        $('#province_select').on("change", function (e) {
            var province_id = $('#province_select').val();
            var province_name = $('#province_select>option[value="' + province_id + '"]').text();
            if (province_id=='-1') {
            }else{
                $.ajax({
                    url:'assets/test/test.json',
                    method : 'GET',
                    dataType :"json",
                    success: function(data){
                        var city=data.data;
                        var city_list=city[province_id].cities;
                        var city_data=[{id:'-1',text:'全部'}];
                        for (var i = 0; i < city_list.length; i++) {
                            city_data.push({id:i,text:city_list[i]})
                        };

                        $("#city_select").select2('destroy');
                        $("#city_select").children().remove();

                        $("#city_select").select2({
                            data:city_data
                        });
                        $('#city_select').select2({
                        data:[{id:0,text:"全部"}]
                        });
                    },
                    error : function(data){
                        alert("something wrong.");
                    }
                })
            };
        });

        /*$('#city_select').on("change", function (e) {
            var city_id = $('#city_select').val();
            if(city_id == 0){
                $('#county_select').val(0).trigger('change');
                return;
            }

            var city_id = $('#city_select').val();
            var city_name = $('#city_select>option[value="' + city_id + '"]').text();
            console.log(city_name);
            if(city_name=="全部"){
                city_name='';
            }

            $.ajax({
                url :'assets/test/company.json',
                dataType : 'json',
                method : 'GET',
                success : function(data){
                    var company_data=transToArry(data.data);
                   // var companys=data.body.companys;
                   // var company_data=[];
                    console.log(data);
                    for (var i = 0; i < companys.length; i++) {
                        company_data.push({id:companys[i].id,text:companys[i].text}})
                    };
                    $("#company_select").select2({
                        data:company_data
                    })
                },
                error : function(data){

                }
            })
        });*/


        $('#wj_version').select2({
            data:[{id:0,text:"2015水泥工业简表"},{id:1,text:"2016水泥工业简表"}]
        });

        $("#submit").on("click",function(){
            alert("记录已保存！");
            var city_id = $('#city_select').val();
            var city_name = $('#city_select>option[value="' + city_id + '"]').text();
            console.log(city_name);
           /* $.ajax({
                url :'assets/test/company.json',
                dataType : 'json',
                method : 'GET',
                success : function(data){
                    var company_data=transToArry(data.data);
                   // var companys=data.body.companys;
                    //var company_data=[];
                    console.log(data);
                    for (var i = 0; i < companys.length; i++) {
                        company_data.push({id:companys[i].id,text:companys[i].text}})
                    };
                    $("#company_select").select2({
                        data:company_data
                    })
                },
                error : function(data){

                }
            })*/
             $.ajax({
            	 url:'/company/getCompanyByAddress.html?address='+city_name,
            	 method:'GET',
            	 contentType:'application/json',
            	 success:function(data) {
            		 console.log(data);
            	 }
             });
        })

    });
})(jQuery);
