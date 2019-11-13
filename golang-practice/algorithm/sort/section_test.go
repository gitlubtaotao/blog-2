package sort_test

import (
	"fmt"
	"testing"
)

func TestSelectorSort(t *testing.T) {
	numbers := []int{30, 55, 22, 100, 99, 33, 1}
	fmt.Println(SelectionSort(numbers))
	fmt.Println(SelectionSortOptimize(numbers))
}

/**
 * TODO: 选择排序 就是通过 n-1 之间的关键字进行比较，从 n - i + 1 个记录中选出最小的记录，
 *  并和 i ( 1 ≤ i ≤ n) 个记录交换。
 *
 * 在数组结构中 选择排序是不稳定的，但在链表结构中 选择排序是稳定的
 */
func SelectionSort(numbers []int) []int {
	for i := 0; i < len(numbers); i++ {
		m := i // 获取数组的第 0 个位置作为最小数值

		// 从 i + 1 的位置进行数值比较, 将最小数值的下标赋值给 m
		for j := i + 1; j < len(numbers); j++ {
			if numbers[m] > numbers[j] {
				m = j
			}
		}

		// 如果 m 与 当前下标不一致，则将 下标 i 和 m 的数值交换位置
		if m != i {
			numbers[i], numbers[m] = numbers[m], numbers[i]
		}
	}
	return numbers
}

/**
 * 选择排序优化，思路：获取数组中最小值和最大值，并交换 最小值 和 最大值 位置
 */
func SelectionSortOptimize(numbers []int) []int {
	// 声明 start、end 两个变量，一个由前往后查找最小值，一个由后往前查找最大值，直到  start, end 两个数值相等，此时外层循环次数为 n/2
	for start, end := 0, len(numbers)-1; start <= end; start, end = start+1, end-1 {
		min := start // 记录最小值下标
		max := end   // 记录最大值下标

		for index := start; index <= end; index++ {
			if numbers[min] > numbers[index] {
				min = index
			}
			if numbers[max] < numbers[index] {
				max = index
			}
		}

		if min != start {
			numbers[min], numbers[start] = numbers[start], numbers[min]
		}

		// 先对 最小值交换会影响最大值的下标位置
		if max == start {
			max = min
		}
		if max != end {
			numbers[max], numbers[end] = numbers[end], numbers[max]
		}
	}

	return numbers
}
