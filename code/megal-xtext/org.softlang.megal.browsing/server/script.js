(function($){

	var nodes = [];
	var edges = [];
	
	
	
	var data = {
		nodes : nodes,
		edges : edges
	};
	
	var options = {
		physics:{
			enabled: false,
		    stabilization: false
		},
		layout: {
            randomSeed: 2,
            hierarchical: {
            	levelSeparation: 500,
            	nodeSpacing: 500,
                direction: "UD",
                sortMethod: "directed",
                edgeMinimization: false
            }
		
        },
		nodes : {
			shape : 'dot',
			size : 20,
			font : {
				size : 15,
				color : '#ffffff'
			},
			borderWidth : 2
		},
		edges : {
			width : 1,
			font : {
				size : 15,
				color : '#ffffff'
			},
			arrows:'to',
			smooth: { enabled: true },
			selfReferenceSize: 50,
		},
		groups : {
			entities : {
				color : {
					background : 'cyan',
					border : 'cyan'
				},
				shape : 'diamond'
			},
			dotsWithLabel : {
				label : "I'm a dot!",
				shape : 'dot',
				color : 'cyan'
			},
			mints : {
				color : 'rgb(0,255,140)'
			},
			icons : {
				shape : 'icon',
				icon : {
					face : 'FontAwesome',
					code : '\uf0c0',
					size : 50,
					color : 'orange'
				}
			},
			source : {
				color : {
					border : 'white'
				}
			}
		}
	};
	

	
	$(function(){
		
		var url = "./rest/megamodel";
		
		return $.getJSON(url, function(megamodel){
			

			var i;
			
//			for (i in megamodel.Entities) {
//				
//				var entity = megamodel.Entities[i];
//				var id = entity.Name;
//				var label = id.substr(id.lastIndexOf(".")+1);
//				
//				if (entity.type == "Language") {
//				
//					nodes.push({
//						id: id,
//						label: label,
//						group: "entities"
//					});
//				
//				}
//				
//			}
			
			for (i in megamodel.EntityTypes) {
				
				var entity = megamodel.EntityTypes[i];
				var id = entity.Name;
				var label = id.substr(id.lastIndexOf(".")+1);
				
				nodes.push({
					id: id,
					label: label,
					group: "entities"
				});
				
			}
			
			
//			for (i in megamodel.Relationships) {
//				var rel = megamodel.Relationships[i];
//				edges.push({
//					from: rel.Left,
//					to: rel.Right,
//					label: rel.Name
//				});
//			}
			
			
			var manies = {};
			
//			console.log(megamodel);
			
			for (i in megamodel.RelationshipTypes) {
				var rel = megamodel.RelationshipTypes[i];
				
//				console.log(rel);
				
				if (rel.IsLeftMany) {
					
					id = rel.Left + "+";
					
					label = id.substr(id.lastIndexOf(".")+1);
					
					if (manies[id] == undefined) {
						
						nodes.push({
							id: id,
							label: label,
							group: "mints"
						});
						edges.push({
							from: id,
							to: rel.Right,
							label: rel.Name
						});
						manies[id] = id;
					}
					
					edges.push({
						from: rel.Left,
						to: id,
						label: "closureOf",
						arrows:'to, from',
						color:{color:'red'}
					});
					
				}
				else {
					
					edges.push({
						from: rel.Left,
						to: rel.Right,
						label: rel.Name
					});
					
				}
				
			}
			
			var selfReferenceSizes = {};
			
			for (i in edges) {
			    var edge = edges[i];
			    if (edge.to == edge.from) {
			      if (selfReferenceSizes[edge.to] == undefined) {
			         selfReferenceSizes[edge.to] = options.edges.selfReferenceSize
			      }
			      else {
			         selfReferenceSizes[edge.to] += options.edges.selfReferenceSize;
			      }
			      edge.selfReferenceSize = selfReferenceSizes[edge.to];
			      console.log(edge);
			    }
			  }
			
//			console.log(edges);
			var container = document.getElementById('mynetwork');
			var network = new vis.Network(container, data, options);
			
		});
		
	});
	
	
}(jQuery));
