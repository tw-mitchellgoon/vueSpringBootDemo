<template>
  <div class="item">
    <div class="title"><slot name="title" /></div>
    <div class="completed">
      <slot name="completed"></slot>
    </div>
  </div>
</template>

<script>
export default {};
</script>
