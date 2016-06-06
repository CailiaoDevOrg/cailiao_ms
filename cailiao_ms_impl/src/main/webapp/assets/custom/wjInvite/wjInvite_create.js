(function($) {    
    $(function() {
        var data_all=[];
        var province_all=[{"id":"-1","text":"请选择"}];
        var city_all=[{"id":"-1","text":"请选择"}]
        var area=[
                {
                "id":"-1",
                "text":"请选择"
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
        $.ajax({
            url : 'assets/test/test.json',
            method: 'GET',
            dataType : "json",
            success : function(data){
                data_all=data.data;//dataall为全部json数据
                for (var i = 0; i < data_all.length; i++) {
                    province_all.push({id:data_all[i].id,text:data_all[i].name});
                };
                $("#province_select").select2({
                    data:province_all
                });
                $('#city_select').select2({
                        data:[{id:-1,text:" 请选择"}]
                });
                $('#company_select').select2({
                        data:[{id:-1,text:"请选择"}]
                    });
            },
            error : function(data){
                 alert('网络出现问题，请稍后重试');
            }
        })

        $('#area').on("change", function (e) {
            var area_id = $('#area').val();
            var province=[];
            for (var i = 0; i < data_all.length; i++) {
                if(data_all[i].area==area_id){
                    province.push({id:i,text:data_all[i].name});
                }
            };
            $("#province_select").select2('destroy');
            $("#province_select").children().remove();
            console.log(province);
            if(province.length == -1) {
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
                        data:[{id:"-1",text:"请选择"}]
                    });
                }
            $("#company_select").select2('destroy');
            $("#company_select").children().remove();
            $('#company_select').select2({
                data:[{id:"-1",text:"请选择"}]
            });           
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
                        var city_data=[{id:'-1',text:'请选择'}];
                        for (var i = 0; i < city_list.length; i++) {
                            city_data.push({id:i,text:city_list[i]})
                        };

                        $("#city_select").select2('destroy');
                        $("#city_select").children().remove();
                        $("#company_select").select2('destroy');
                        $("#company_select").children().remove();

                        $("#city_select").select2({
                            data:city_data
                        });
                        $('#company_select').select2({
                        data:[{id:"-1",text:" 请选择"}]
                        });
                    },
                    error : function(data){
                        alert("something wrong.");
                    }
                })
            };
        });

        $('#city_select').on("change", function (e) {
            var city_id = $('#city_select').val();
            var city_name = $('#city_select>option[value="' + city_id + '"]').text();
            if(city_id == 0){
                city_name='';
            }
            console.log(city_name);
            $.ajax({
                url:'/company/getCompanyByAddress.html?address='+city_name,
                method:'GET',
                contentType:'application/json',
                success : function(data){
                    var company_data_obj=JSON.parse(data);
                    var companys=company_data_obj.body.companys;
                    var company_data=[];
                    for (var i = 0; i < companys.length; i++) {
                        company_data.push({id:companys[i].id,text:companys[i].name})
                    };
                    console.log(company_data);
                    $("#company_select").select2('destroy');
                    $("#company_select").children().remove();
                    $("#company_select").select2({
                        data:company_data
                    })
                },
                error : function(data){

                }
            })
        });


        $.ajax({
                url: 'online/news/getList.html',
                method: 'GET',
                contentType: 'application/json',
                success: function(data) {
                    data = JSON.parse(data);
                    if (data.retCode == 200) {
                        var newsList = data.body.newsList;
                        var wj_version=[{id:"-1",text:" 请选择"}];
                        for (var i = 0; i < newsList.length; i++) {
                            wj_version.push({id:i,text:newsList[i].title});
                        };
                        $('#wj_version').select2({
                            data:wj_version
                        });
                    } else {
                        alert('系统忙，新闻无法加载');
                    }
                },
                error: function(data) {
                    alert('网络出现问题，新闻无法加载');
                }
            });

        $("#submit").on("click",function(){
            var company_id = $('#city_select').val();
            var company_name = $('#city_select>option[value="' + company_id + '"]').text();

            alert("提交成功")
        })
    });
})(jQuery);
