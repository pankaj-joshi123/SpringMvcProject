module.exports=function(grunt) {
	

grunt.initConfig({
    pkg: grunt.file.readJSON('package.json'),
 

 uglify: {
	option: {
  	  manage:false
	},
	mytarget: {
 	 files: {
   	  'compress/ugliJS2.js':['www/**.js']
	  }
	}
  },

 ngAnnotate: {
    options: {
        singleQuotes: true
    },
    app: {
        files: {
         'www/author.js': ['www/author.js']
        }
    }
},
  
  htmlmin: {
     options: {
          collapseWhitespace: true,
          conservativeCollapse: true,
          collapseBooleanAttributes: true,
          removeCommentsFromCDATA: true,
          removeOptionalTags: true
     },
     mytarget: {
	files: {
 	  'htmlMin.html':['www/**.html']
      }
    }
  },

  watch: {
       options:{livereload:true},

       files:['www/*.html','www/*.js'],
       tasks:['build']
  },

  express:{
     all:{
       options:{
          port:9000,
          hostname:'localhost',
          bases:['.'],
          livereload:true
       }
     }
  }

});

  grunt.registerTask("build",['htmlmin','ngAnnotate','uglify'])
  grunt.registerTask("server",['express','watch'])

  grunt.loadNpmTasks('grunt-contrib-uglify');
  grunt.loadNpmTasks('grunt-contrib-htmlmin');
  grunt.loadNpmTasks('grunt-ng-annotate');
  grunt.loadNpmTasks('grunt-contrib-watch');
  grunt.loadNpmTasks('grunt-express');
  grunt.loadNpmTasks('grunt-parallel');
  grunt.loadNpmTasks('grunt-contrib-livereload');
};

