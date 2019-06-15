/**
 * 
 */
	// 取得Element：
	function getE(id){
		ele=document.getElementById(id);
		return ele;
	}
	// 全部設成disabled：
	function allDisable(elets,excepts){
		elets.forEach(function(elemt){
			elemt.disabled=true;
			elemt.bgcolor="gray";
		});
		if(Array.isArray(excepts)){
			excepts.forEach(function(elemt){
				elemt.disabled=false;
			});
		}
		
	}
	// 全部設成enabled：
	function allEnable(elets,excepts){
		elets.forEach(function(elemt){
			elemt.disabled=false;
		});
		if(Array.isArray(excepts)){
			excepts.forEach(function(elemt){
				elemt.disabled=true;
			});
		}
	}
	
	
	
