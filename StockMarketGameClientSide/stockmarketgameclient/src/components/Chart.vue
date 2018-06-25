<script>
import VueCharts from 'vue-chartjs'
import { Line } from 'vue-chartjs'
 
export default {
  extends: Line,
  props: ['idData'],
  mounted () {
    //this.renderChart(this.data, this.options)
    this.renderChart({
      labels:['1', '2', '3', '4', '5'],
      datasets: [
        {
          label: 'Round Score',
          backgroundColor: '#00b297',
          data: this.idData
        }
      ]
    });
  }
}
</script>