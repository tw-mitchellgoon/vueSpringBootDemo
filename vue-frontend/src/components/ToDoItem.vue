<template>
  <div class="item">
    <span class="title"><slot name="title" /></span>
    <span class="completed">
      <slot name="completed"></slot>
    </span>
  </div>
</template>

<script>
export default {};
</script>
