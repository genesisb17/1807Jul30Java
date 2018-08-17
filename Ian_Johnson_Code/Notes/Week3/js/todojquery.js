$(document).ready(() => {
  $('#add-item').click(() => {
    const itemText = $('#item-text').val();
    const item = $('<li/>').text(itemText);
    // item.click(() => {
    //   item.appendTo('#done-list');
    // });
    item.appendTo($('#todo-list'));
    $('#item-text').val('');
  });
});
