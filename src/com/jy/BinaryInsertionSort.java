package com.jy;

import java.util.Arrays;

public class BinaryInsertionSort {

	public static void main(String[] args) {
		DataWrap[] dataWraps = new DataWrap[] { new DataWrap(9, ""), new DataWrap(-16, ""), new DataWrap(21, ""),
				new DataWrap(23, ""), new DataWrap(-30, ""), new DataWrap(-49, ""), new DataWrap(21, ""),
				new DataWrap(30, ""), new DataWrap(13, "") };

		System.out.println("排序前：" + Arrays.toString(dataWraps));
		// 开始时间
		long startTime = System.currentTimeMillis();
		binaryInsertionSort(dataWraps);
		// 结束时间
		long stopTime = System.currentTimeMillis();
		System.out.println("*********************排序结束*********************");
		System.out.println("排序耗时t：" + (stopTime - startTime) + "ms");
		System.out.println("排序后（从小到大）：" + Arrays.toString(dataWraps));
	}

	/**
	 * 折半插入法排序
	 * 
	 * @param dataWraps
	 *            待排序的数组
	 */
	public static void binaryInsertionSort(DataWrap[] dataWraps) {
		System.out.println("*********************开始排序*********************");
		int arrayLength = dataWraps.length;
		for (int i = 1; i < arrayLength; i++) {
			// 保存当前比较的值，当整体后移是保证改值不会丢失
			DataWrap temp = dataWraps[i];
			// 只有当前元素temp比前一个元素小才需要进行下面的操作，否则temp和前面的元素自然就组成排序数组
			if (dataWraps[i].compareTo(dataWraps[i - 1]) < 0) {
				// 折半的高、低位索引
				int high = i - 1;
				int low = 0;
				while (low <= high) {
					// 高低位的中间位置索引
					int mid = (low + high) >> 1;
					// 根据比较结果来调整高低位的索引
					if (dataWraps[i].compareTo(dataWraps[mid]) > 0)
						low = mid + 1;
					else
						high = mid - 1;
				}
				// 将从low到i处的元素整体往后移1位
				for (int j = i; j > low; j--)
					dataWraps[j] = dataWraps[j - 1];
				// 在索引low处插入当前temp元素
				dataWraps[low] = temp;
				// 每一趟后都打印出当前的排序结果
				System.out.println(Arrays.toString(dataWraps));
			}

		}
	}

}
