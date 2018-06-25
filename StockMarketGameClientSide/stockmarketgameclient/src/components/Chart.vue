<script>
import VueCharts from 'vue-chartjs'
import { Line } from 'vue-chartjs'
 
export default {
  extends: Line,
  //props: ['idData'],
  mounted () {
    //this.renderChart(this.data, this.options)
    this.renderChart({
      labels:['1', '2', '3', '4', '5'],
      datasets: [
        {
          label: 'GitHub Commits',
          backgroundColor: '#f87979',
          data: [40, 20, 12, 39, 10]
        }
      ]
    });
  }
}
</script>