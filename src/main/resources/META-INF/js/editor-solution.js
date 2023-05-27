ClassicEditor.create( document.querySelector( '#editor' ) ).catch( error => {
    console.error( error );
} ); 
ClassicEditor.create( document.querySelector( '#editor1' ) )
.then( editor => {
	window.editor1 = editor;
} )
.catch( err => {
	console.error( err.stack );
} );

ClassicEditor.create( document.querySelector( '#editor2' ) )
.then( editor => {
	window.editor2 = editor;
} )
.catch( err => {
	console.error( err.stack );
} );
ClassicEditor.create( document.querySelector( '#editor3' ) )
.then( editor => {
window.editor3 = editor;
} )
.catch( err => {
console.error( err.stack );
} );
  